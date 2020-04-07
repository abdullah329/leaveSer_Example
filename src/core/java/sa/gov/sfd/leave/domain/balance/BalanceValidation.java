package sa.gov.sfd.leave.domain.balance;

import sa.gov.sfd.leave.domain.balance.exception.DuplicateOpenBalance;
import sa.gov.sfd.leave.domain.balance.exception.NoApplicationForBalance;
import sa.gov.sfd.leave.model.Balance;

public class BalanceValidation {

    private final BalanceDao dao;

    public BalanceValidation(BalanceDao dao) {
        this.dao = dao;
    }

    public void validateOpenBalance(Balance balance) {
        if (duplicateOpenBalance(balance))
            throw new DuplicateOpenBalance();
    }

    public void validateTransactionBalance(Balance balance) {
        if (balance.getApplicationID() == null)
            throw new NoApplicationForBalance();
    }

    private boolean duplicateOpenBalance(Balance balance) {
        return !dao.findDuplicateOpenBalance(balance);
    }


}
