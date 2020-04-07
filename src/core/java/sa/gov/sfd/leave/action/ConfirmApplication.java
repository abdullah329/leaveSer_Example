package sa.gov.sfd.leave.action;

import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.domain.balance.BalanceService;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.model.Balance;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author malsharhan@sfd.gov.sa
 * @version 1.0
 */

public class ConfirmApplication {

    private final ApplicationService applicationService;
    private final BalanceService balanceService;

    public ConfirmApplication(ApplicationService applicationService
            , BalanceService balanceService) {
        this.applicationService = applicationService;
        this.balanceService = balanceService;
    }

    /**
     * Confirm the employee leaving application by HR or permit employee.
     * the confirmation will change the employee leaving balance.
     * status(2) is represent the confirmation status
     * priority(100) represent nothing in workflow table, but it is here because the workflow priority is one of composite primary key
     *
     * @param application is the leaving application which required an action from permit employee.
     */
    @Transactional
    public void confirm(Application application) {

        application.setStatus((short) 2);
        application.setCreatedDate(LocalDateTime.now());
        application.setWorkflow(null);
        application.setWorkflowPriority(100);
        applicationService.confirm(application);

        addDebitBalanceTransaction(application.getId(), application.getUserNid(), application.getDuration(), application.getType());
    }

    /**
     * Add debit transaction to employee leaving balance
     *
     * @param applicationId which used as a foreign key with balance transasciton
     * @param userNid       this used mainly when we add new credit balance to employee at the beginning of financial year
     * @param duration      the leaving application duration, which used to debit from balance
     * @param type          this is leaving type
     */
    private void addDebitBalanceTransaction(long applicationId, int userNid, int duration, Short type) {
        List<Balance> balanceList = balanceService.getCurrentBalanceForEmployee(userNid, type);

        List<Balance> listToInsert = calculateBalance(applicationId, duration, balanceList);

        listToInsert.forEach(balanceService::addNewBalanceRecord);
    }


    /**
     * This function will deduct the duration of leaving application from employee balance based on year by earlier ended
     * date,
     *
     * @param applicationId
     * @param duration
     * @param balanceList   current employee leaving balance
     * @return list of debit balance to insert it in balance transaction
     */

    private List<Balance> calculateBalance(long applicationId, int duration, List<Balance> balanceList) {
        List<Balance> sortedBalance = balanceList.stream()
                .sorted(Comparator.comparing(Balance::getEndDateAg, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());

        for (Balance x : sortedBalance)
            if (duration != 0)
                if (x.getBalance() > duration) {
                    x.setBalance(duration);
                    duration = 0;
                    x.setApplicationID(applicationId);
                    x.setCreditOrDebit((short) -1);
                    x.setId(new Random().nextLong());

                } else {
                    duration = duration - x.getBalance();
                    x.setBalance(duration);
                    x.setApplicationID(applicationId);
                    x.setCreditOrDebit((short) -1);
                    x.setId(new Random().nextLong());
                }


        return sortedBalance
                .stream()
                .filter(x -> x.getCreditOrDebit() != null)
                .filter(x -> x.getCreditOrDebit() == -1)
                .collect(Collectors.toList());
    }
}
