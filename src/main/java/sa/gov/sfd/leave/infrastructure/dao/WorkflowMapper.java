package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.RowMapper;
import sa.gov.sfd.leave.model.Workflow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkflowMapper implements RowMapper<Workflow> {

    @Override
    public Workflow mapRow(ResultSet resultSet, int i) throws SQLException {
        Workflow model = new Workflow();

        model.setId(resultSet.getLong("ID"));
        model.setPermissionsGroup(resultSet.getLong("GROUP_ID"));
        model.setPriority(resultSet.getInt("PRIORITY"));
        model.setAction(resultSet.getString("ACTION"));
//        model.setCreatedDate(resultSet.getTimestamp("CREATED_DATE").toLocalDateTime());
        return model;
    }
}
