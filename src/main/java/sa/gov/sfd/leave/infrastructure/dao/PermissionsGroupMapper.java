package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.RowMapper;
import sa.gov.sfd.leave.model.PermissionsGroup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionsGroupMapper implements RowMapper<PermissionsGroup> {

    @Override
    public PermissionsGroup mapRow(ResultSet resultSet, int i) throws SQLException {
        PermissionsGroup model = new PermissionsGroup();
        model.setId(resultSet.getLong("ID"));
        model.setGroupName(resultSet.getString("GROUP_NAME"));
        model.setEmployees(resultSet.getString("EMPLOYEES"));
        return model;
    }
}
