package sa.gov.sfd.leave.action;

import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.domain.balance.BalanceService;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.model.Balance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


/**
 * @author malsharhan@sfd.gov.sa
 * @version 1.0
 */

public class CancelApplication {

    private final ApplicationService applicationService;
    private final BalanceService balanceService;

    public CancelApplication(ApplicationService applicationService
            , BalanceService balanceService) {
        this.applicationService = applicationService;
        this.balanceService = balanceService;
    }

    /**
     * Cancel confirm application, and reverse balance transaction,
     * add status(4) which mean canceled application
     *
     * @param application is the application which required cancellation action
     */
    @Transactional
    public void cancel(Application application) {

        application.setCreatedDate(LocalDateTime.now());
        application.setWorkflowPriority(-2);
        application.setStatus((short) 4);

        applicationService.cancel(application);

        addCreditBalanceTransaction(application.getId());

    }

    /**
     * Reverse the balance transaction by add credit transaction with same values.
     *
     * @param applicationId
     */

    private void addCreditBalanceTransaction(long applicationId) {
        List<Balance> applicationBalance = balanceService.getBalanceTransactionForApplication(applicationId);

        applicationBalance.forEach(balance -> {
            balance.setId(new Random().nextLong());
            balance.setCreditOrDebit((short) 1);
            balance.setApplicationID(null);
        });

        applicationBalance.forEach(balanceService::addNewBalanceRecord);

    }

}
