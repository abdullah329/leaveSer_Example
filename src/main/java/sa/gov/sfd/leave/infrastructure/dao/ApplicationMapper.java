package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.RowMapper;
import sa.gov.sfd.leave.model.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

class ApplicationMapper implements RowMapper<Application> {
    @Override
    public Application mapRow(ResultSet resultSet, int i) throws SQLException {
        Application model = new Application();
        model.setId(resultSet.getLong("ID"));
        model.setWorkflowPriority(resultSet.getInt("PRIORITY_ORDER"));
        model.setUserNid(resultSet.getInt("USER_NID"));
        model.setStartDateAh(resultSet.getString("START_DATE_AH"));
        model.setStartDateAg(resultSet.getDate("START_DATE_AG").toLocalDate());
        model.setDuration(resultSet.getShort("DURATION"));
        model.setRequestDateAndTime(resultSet.getTimestamp("REQUEST_DATE").toLocalDateTime());
        model.setStatus(resultSet.getShort("STATUS"));
        model.setWorkflow(resultSet.getLong("WORKFLOW"));
        model.setType(resultSet.getShort("TYPE"));

        return model;
    }
}
