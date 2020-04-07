package sa.gov.sfd.leave.action;

import sa.gov.sfd.leave.domain.balance.BalanceService;
import sa.gov.sfd.leave.model.Balance;

import java.util.List;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */
public class GetCurrentBalance {

    private final BalanceService balanceService;

    public GetCurrentBalance(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    /**
     * Get List of current employee leaving balance.
     * @param userNid is the employee national Id
     * @param type is the leaving type
     * @return list of balance
     */
    public List<Balance> getBalance(Integer userNid, Short type){

        return balanceService.getCurrentBalanceForEmployee(userNid, type);
    }
}
