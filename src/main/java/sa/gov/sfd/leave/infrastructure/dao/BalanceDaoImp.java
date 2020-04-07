package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.balance.BalanceDao;
import sa.gov.sfd.leave.model.Balance;

import java.util.List;

@Repository
public class BalanceDaoImp implements BalanceDao {

    private final JdbcTemplate template;

    public BalanceDaoImp(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Balance> findCurrentBalanceByEmployeeID(int employeeId, Short type) {
            return template.query("select" +
                    "       user_nid,\n" +
                    "       year,\n" +
                    "       start_efct_date_ag,\n" +
                    "       end_efct_date_ag,\n" +
                    "       start_efct_date_ah,\n" +
                    "       end_efct_date_ah,\n" +
                    "       type,\n" +
                    "       sum(balance * credit_or_debit) as balance\n" +
                    "from BALANCE_TRANSACTION\n" +
                    "where USER_NID = ?\n" +
                    "  and TYPE = ?\n" +
                    "  and (END_EFCT_DATE_AG >= sysdate or END_EFCT_DATE_AG not like null)\n" +
                    "group by year", new Object[]{employeeId, type}, new BalanceMapper());
    }

    @Override
    public List<Balance> findByApplicationId(long applicationId) {
        return template.query("SELECT ID,\n" +
                "       APPLICATION_ID,\n" +
                "       USER_NID,\n" +
                "       YEAR,\n" +
                "       START_EFCT_DATE_AG,\n" +
                "       END_EFCT_DATE_AG,\n" +
                "       START_EFCT_DATE_AH,\n" +
                "       END_EFCT_DATE_AH,\n" +
                "       TYPE,\n" +
                "       BALANCE,\n" +
                "       CREDIT_OR_DEBIT\n" +
                "FROM BALANCE_TRANSACTION\n" +
                "WHERE APPLICATION_ID = ?", new Object[]{applicationId}, new BalanceTransactionMapper());
    }

    @Override
    public List<Balance> findBalanceTransactionByEmployeeID(int employeeId) {
        return template.query("SELECT ID,\n" +
                "       APPLICATION_ID,\n" +
                "       USER_NID,\n" +
                "       YEAR,\n" +
                "       START_EFCT_DATE_AG,\n" +
                "       END_EFCT_DATE_AG,\n" +
                "       START_EFCT_DATE_AH,\n" +
                "       END_EFCT_DATE_AH,\n" +
                "       TYPE,\n" +
                "       BALANCE,\n" +
                "       CREDIT_OR_DEBIT\n" +
                "FROM BALANCE_TRANSACTION\n" +
                "WHERE USER_NID = ?", new Object[]{employeeId}, new BalanceTransactionMapper());
    }

    @Transactional
    @Override
    public void insertBalance(Balance balance) {

        template.update("INSERT INTO BALANCE_TRANSACTION (ID, APPLICATION_ID, USER_NID, YEAR, START_EFCT_DATE_AG, END_EFCT_DATE_AG,\n" +
                        "                                 START_EFCT_DATE_AH, END_EFCT_DATE_AH, TYPE, BALANCE, CREDIT_OR_DEBIT)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                balance.getId()
                , balance.getApplicationID()
                , balance.getEmployeeID()
                , balance.getYear()
                , balance.getStartDateAg()
                , balance.getEndDateAg()
                , balance.getStartDateAh()
                , balance.getEndDateAh()
                , balance.getType()
                , balance.getBalance()
                , balance.getCreditOrDebit());
    }


    @Override
    public boolean findDuplicateOpenBalance(Balance balance) {
        return template.query("select id,\n" +
                        "       application_id,\n" +
                        "       user_nid,\n" +
                        "       year,\n" +
                        "       start_efct_date_ag,\n" +
                        "       end_efct_date_ag,\n" +
                        "       start_efct_date_ah,\n" +
                        "       end_efct_date_ah,\n" +
                        "       type,\n" +
                        "       balance,\n" +
                        "       credit_or_debit\n" +
                        "from BALANCE_TRANSACTION\n" +
                        "where APPLICATION_ID is null\n" +
                        "  " +
                        "and year = ?\n" +
                        "  " +
                        "and USER_NID = ?\n" +
                        "  " +
                        "and TYPE = ?\n" +
                        "  " +
                        "and BALANCE = ?\n" +
                        "  " +
                        "and CREDIT_OR_DEBIT = 1"
        , new Object[]{balance.getYear(), balance.getEmployeeID(), balance.getType(), balance.getBalance()}
        , new BalanceTransactionMapper()).isEmpty();
    }
}
