package sa.gov.sfd.leave.domain.balance;

import sa.gov.sfd.leave.model.Balance;

import java.util.List;

public class BalanceServiceImpl implements BalanceService {


    private final BalanceDao dao;
    private final BalanceValidation validation;

    public BalanceServiceImpl(BalanceDao dao, BalanceValidation validation) {
        this.dao = dao;
        this.validation = validation;
    }

    @Override
    public List<Balance> getCurrentBalanceForEmployee(int employeeId, Short type) {
        return dao.findCurrentBalanceByEmployeeID(employeeId, type);
    }

    @Override
    public List<Balance> getBalanceTransactionForApplication(long application) {
        return dao.findByApplicationId(application);
    }

    @Override
    public List<Balance> getBalanceTransactionForEmployee(int employeeId) {
        return dao.findBalanceTransactionByEmployeeID(employeeId);
    }

    @Override
    public void addNewBalanceRecord(Balance balance) {
        validation.validateTransactionBalance(balance);
        dao.insertBalance(balance);
    }

    @Override
    public void addOpenYearBalance(Balance balance){
        validation.validateOpenBalance(balance);
        dao.insertBalance(balance);
    }
}
