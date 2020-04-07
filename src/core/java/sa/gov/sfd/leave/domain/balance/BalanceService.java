package sa.gov.sfd.leave.domain.balance;

import sa.gov.sfd.leave.model.Balance;

import java.util.List;
/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public interface BalanceService {


    /**
     * Retrieve current employee's leaving balance
     * @param employeeId employee national id
     * @param type leaving type for example 1,2,3
     * @return list of balance grouped by year
     */
    List<Balance> getCurrentBalanceForEmployee(int employeeId, Short type);

    /**
     * Retrieve  balance transactions which is create by application, it can be used with reverse balance changing after
     * cancellation request.
     * @param applicationId application id
     * @return list of balance transaction
     */
    List<Balance> getBalanceTransactionForApplication(long applicationId);

    /**
     * Retrieve all balance transaction for employee
     * @param employeeId employee national id
     * @return list of balance transaction
     */
    List<Balance> getBalanceTransactionForEmployee(int employeeId);

    /**
     * Create a new balance transaction record
     * @param balance balance object
     */
    void addNewBalanceRecord(Balance balance);

    void addOpenYearBalance(Balance balance);
}
