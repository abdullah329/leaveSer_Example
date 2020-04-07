package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.RowMapper;
import sa.gov.sfd.leave.model.Balance;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BalanceTransactionMapper implements RowMapper<Balance> {

    @Override
    public Balance mapRow(ResultSet resultSet, int i) throws SQLException {
        Balance model = new Balance();

        model.setId(resultSet.getLong("ID"));
        model.setApplicationID(resultSet.getLong("APPLICATION_ID"));
        model.setEmployeeID(resultSet.getInt("USER_NID"));
        model.setYear(resultSet.getInt("YEAR"));
        model.setStartDateAg(resultSet.getDate("START_EFCT_DATE_AG").toLocalDate());
        model.setEndDateAg(resultSet.getDate("END_EFCT_DATE_AG").toLocalDate());
        model.setStartDateAh(resultSet.getString("START_EFCT_DATE_AH"));
        model.setEndDateAh(resultSet.getString("END_EFCT_DATE_AH"));
        model.setType(resultSet.getShort("TYPE"));
        model.setBalance(resultSet.getInt("BALANCE"));
        model.setCreditOrDebit(resultSet.getShort("CREDIT_OR_DEBIT"));

        return model;

    }
}
