package sa.gov.sfd.leave.domain.balance;

import sa.gov.sfd.leave.model.Balance;

import java.util.List;

public interface BalanceDao {

    List<Balance> findCurrentBalanceByEmployeeID(int employeeId, Short type);

    List<Balance> findByApplicationId(long applicationId);

    List<Balance> findBalanceTransactionByEmployeeID(int employeeId);

    void insertBalance(Balance balance);

    boolean findDuplicateOpenBalance(Balance balance);
}
