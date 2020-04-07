package sa.gov.sfd.leave.domain.path;


import sa.gov.sfd.leave.model.EmployeeApprovalPath;
import sa.gov.sfd.leave.model.Workflow;

import java.util.List;
import java.util.Optional;

public interface ApprovalPathDao {

    List<EmployeeApprovalPath> findByWorkflow(Workflow workflow);

    Optional<EmployeeApprovalPath> findById(Integer userNid);
}
