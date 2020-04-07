package sa.gov.sfd.leave.domain.workflow;


import sa.gov.sfd.leave.model.Workflow;

import java.util.List;
import java.util.Optional;

public interface WorkflowDao{
    Optional<Workflow> findByIdAndPriority(Long id, int priority);

    Optional<Workflow> findById(long id);

    List<Workflow> findAll();

    void save(Workflow workflow);

    List<Workflow> findByGroupIds(List<Long> groupIds);

//   Workflow findByWorkflowId(WorkflowId id);

}
