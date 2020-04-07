package sa.gov.sfd.leave.domain.workflow;


import sa.gov.sfd.leave.model.Workflow;

import java.util.List;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public interface WorkflowService {

    /**
     * Retrieve all workflow objects
     * @return list of workflow objects
     */
    List<Workflow> findAllWorkflow();


    /**
     * insert or update workflow object
     * @param workflow workflow object
     */
    void save(Workflow workflow);

    /**
     * Retrieve workflow object by id and priority
     * @param id workflow id
     * @param priority priority or workflow order
     * @return Workflow object
     */
    Workflow findWorkflowById(Long id, int priority);

    /**
     * Retrieve all workflow that asigne to the list of group
     * @param groupIds group IDs
     * @return list of Workflow objects
     */
    List<Workflow> findByGroupIds(List<Long> groupIds);
}
