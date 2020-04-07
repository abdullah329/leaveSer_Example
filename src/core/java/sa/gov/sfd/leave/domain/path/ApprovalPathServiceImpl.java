package sa.gov.sfd.leave.domain.path;


import sa.gov.sfd.leave.model.EmployeeApprovalPath;
import sa.gov.sfd.leave.model.Workflow;

import java.util.List;

public  class ApprovalPathServiceImpl implements ApprovalPathService {

    private final ApprovalPathDao dao;

    public ApprovalPathServiceImpl(ApprovalPathDao dao) {
        this.dao = dao;
    }

    @Override
    public List<EmployeeApprovalPath> findByWorkflowId(Workflow workflow) {
        return dao.findByWorkflow(workflow);
    }

    @Override
    public EmployeeApprovalPath findByUserNid(Integer userNid) {
        return dao.findById(userNid).orElseThrow(IllegalArgumentException::new);
    }
}
