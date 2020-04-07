package sa.gov.sfd.leave.infrastructure.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.application.ApplicationDao;
import sa.gov.sfd.leave.model.Application;

import java.util.List;
import java.util.Optional;

@Repository
class ApplicationDaoImpl implements ApplicationDao {

    private final
    JdbcTemplate template;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public ApplicationDaoImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Application> findByUserNid(Integer userNid) {
        return template.query("SELECT ID,\n" +
                "       PRIORITY_ORDER,\n" +
                "       USER_NID,\n" +
                "       START_DATE_AG,\n" +
                "       START_DATE_AH,\n" +
                "       DURATION,\n" +
                "       REQUEST_DATE,\n" +
                "       workflow,\n" +
                "       TYPE,\n" +
                "       STATUS\n" +
                "FROM APPLICATION_TRANSACTION app \n" +
                "WHERE USER_NID = ? " +
                "and PRIORITY_ORDER = (select max(PRIORITY_ORDER) from APPLICATION_TRANSACTION pr where app.ID = pr.ID)", new Object[]{userNid}, new ApplicationMapper());
    }

    @Override
    public Application findByIdLatestTransaction(Long id) {
        return template.queryForObject("select id,\n" +
                "       priority_order,\n" +
                "       user_nid,\n" +
                "       start_date_ag,\n" +
                "       start_date_ah,\n" +
                "       duration,\n" +
                "       request_date,\n" +
                "       WORKFLOW,\n" +
                "       type,\n" +
                "       status\n" +
                "from APPLICATION_TRANSACTION app\n" +
                "where ID = ?\n" +
                "  and PRIORITY_ORDER = (select max(PRIORITY_ORDER) from APPLICATION_TRANSACTION pr where app.ID = pr.ID)", new Object[]{id}, new ApplicationMapper());
    }

    @Override
    public List<Application> findAll() {
        return template.query("SELECT id,\n" +
                "       priority_order,\n" +
                "       user_nid,\n" +
                "       start_date_ag,\n" +
                "       start_date_ah,\n" +
                "       duration,\n" +
                "       request_date,\n" +
                "       WORKFLOW,\n" +
                "       type,\n" +
                "       status\n" +
                "FROM APPLICATION_TRANSACTION", new ApplicationMapper());
    }

    @Override
    public Optional<Application> findById(Long id, Integer priority) {
        String sql = "select id,\n" +
                "       priority_order,\n" +
                "       user_nid,\n" +
                "       start_date_ag,\n" +
                "       start_date_ah,\n" +
                "       duration,\n" +
                "       request_date,\n" +
                "       WORKFLOW,\n" +
                "       type,\n" +
                "       status\n" +
                "from APPLICATION_TRANSACTION\n" +
                "where id = ? and PRIORITY_ORDER = ?";
        return Optional.ofNullable(template.queryForObject(sql, new Object[]{id, priority}, new ApplicationMapper()));
    }

    @Override
    public boolean findByIdPriorityStatus(Long id, Integer priority, Short status) {
        String sql = "select id,\n" +
                "       priority_order,\n" +
                "       user_nid,\n" +
                "       start_date_ag,\n" +
                "       start_date_ah,\n" +
                "       duration,\n" +
                "       request_date,\n" +
                "       WORKFLOW,\n" +
                "       type,\n" +
                "       status\n" +
                "from APPLICATION_TRANSACTION\n" +
                "where id = ? and PRIORITY_ORDER = ? and STATUS = ?";
        List<Application> app = template.query(sql, new Object[]{id, priority, status}, new ApplicationMapper());
        return app.isEmpty();
    }

    @Transactional
    @Override
    public long insertNewApplication(Application application) {
        return template.update("INSERT INTO APPLICATION_TRANSACTION (id,PRIORITY_ORDER, USER_NID, START_DATE_AG, START_DATE_AH, DURATION, REQUEST_DATE,\n" +
                        "                                     WORKFLOW, TYPE, STATUS)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ",
                application.getId(),
                application.getWorkflowPriority(),
                application.getUserNid(),
                application.getStartDateAg(),
                application.getStartDateAh(),
                application.getDuration(),
                application.getRequestDateAndTime(),
                application.getWorkflow(),
                application.getType(),
                application.getStatus());
    }

    @Transactional
    @Override
    public void insertNewAction(Application application) {
        template.update("INSERT INTO APPLICATION_TRANSACTION (id,PRIORITY_ORDER, USER_NID, START_DATE_AG, START_DATE_AH, DURATION, REQUEST_DATE,\n" +
                        "                                     WORKFLOW, TYPE, STATUS)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ",
                application.getId(),
                application.getWorkflowPriority(),
                application.getUserNid(),
                application.getStartDateAg(),
                application.getStartDateAh(),
                application.getDuration(),
                application.getRequestDateAndTime(),
                application.getWorkflow(),
                application.getType(),
                application.getStatus());

    }


    @Override
    public List<Application> findByWorkflowId(List<Long> permissionsId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("pId", permissionsId);
        return namedParameterJdbcTemplate.query("select id,\n" +
                "       priority_order,\n" +
                "       user_nid,\n" +
                "       start_date_ag,\n" +
                "       start_date_ah,\n" +
                "       duration,\n" +
                "       request_date,\n" +
                "       WORKFLOW,\n" +
                "       type,\n" +
                "       status\n" +
                "from APPLICATION_TRANSACTION app\n" +
                "where WORKFLOW in (:pId)\n" +
                "  and PRIORITY_ORDER = (select max(PRIORITY_ORDER) from APPLICATION_TRANSACTION pr where app.ID = pr.ID)\n" +
                "  and PRIORITY_ORDER not in (100,4, 3)\n" +
                "  and STATUS not in (3, -1)", parameters, new ApplicationMapper());
    }

    @Override
    public boolean findByStartDateAndDuration(Application application) {
        return template.query("select id,\n" +
                        "       priority_order,\n" +
                        "       user_nid,\n" +
                        "       start_date_ag,\n" +
                        "       start_date_ah,\n" +
                        "       duration,\n" +
                        "       request_date,\n" +
                        "       WORKFLOW,\n" +
                        "       type,\n" +
                        "       status\n" +
                        "from APPLICATION_TRANSACTION app\n" +
                        "where USER_NID = ?\n" +
                        "  " +
                        "and START_DATE_AG = ?\n" +
                        "  " +
                        "and DURATION = ?\n" +
                        "  and PRIORITY_ORDER = (select max(PRIORITY_ORDER) from APPLICATION_TRANSACTION pr where app.ID = pr.ID)\n" +
                        "  and STATUS not in (4, 3)"
                , new Object[]{application.getUserNid(), application.getStartDateAg(), application.getDuration()}
                , new ApplicationMapper()).isEmpty();
    }

    @Override
    public List<Application> findByStartDate(Application application) {
        return null;
    }
}
