package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupDao;
import sa.gov.sfd.leave.model.PermissionsGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
class PermissionsGroupDaoImp implements PermissionsGroupDao {

    final
    JdbcTemplate template;

    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PermissionsGroupDaoImp(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<PermissionsGroup> findAll() {
        return template.query("select id, group_name, employees, permissions from GROUP_PERMISSIONS", new PermissionsGroupMapper());
    }

    @Override
    public Optional<PermissionsGroup> findById(Long permissionsGroup) {
        return Optional.ofNullable(template.queryForObject("select * from GROUP_PERMISSIONS where ID = ?", new Object[]{permissionsGroup}, new PermissionsGroupMapper() ));
    }

    @Override
    public List<PermissionsGroup> findByUserNid(Integer userNid) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("user", "%"+userNid+"%");
        return namedParameterJdbcTemplate.query("select ID,GROUP_NAME,EMPLOYEES" +
                        " from GROUP_PERMISSIONS where EMPLOYEES like :user", parameters
                , new PermissionsGroupMapper());
    }
}
