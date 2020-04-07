package sa.gov.sfd.leave.domain.workflow;


import sa.gov.sfd.leave.model.Workflow;

import java.util.List;

public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowDao dao;

    public WorkflowServiceImpl(WorkflowDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Workflow> findAllWorkflow() {
        return dao.findAll();
    }

    @Override
    public void save(Workflow workflow) {
        dao.save(workflow);
    }

    @Override
    public Workflow findWorkflowById(Long id, int priority) {
        return dao.findByIdAndPriority(id, priority).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Workflow> findByGroupIds(List<Long> groupIds) {
        return dao.findByGroupIds(groupIds);
    }

    //    @Override
//    public long getWorkflowOrderById(Long id, int priority) {
//        return dao.findByIdAndPriority(id, priority).orElseThrow(IllegalArgumentException::new).getPermissionsGroup();
//    }
}
