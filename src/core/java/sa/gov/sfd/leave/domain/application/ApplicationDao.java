package sa.gov.sfd.leave.domain.application;


import sa.gov.sfd.leave.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationDao {

    List<Application> findByUserNid(Integer userNid);

    List<Application> findAll();

    Application findByIdLatestTransaction(Long id);

    Optional<Application> findById(Long id, Integer priority);

    boolean findByIdPriorityStatus(Long id, Integer priority, Short status);

    long insertNewApplication(Application application);

    void insertNewAction(Application application);

    List<Application> findByWorkflowId(List<Long> permissionsId);

    boolean findByStartDateAndDuration(Application application);

    List<Application> findByStartDate(Application application);
}
