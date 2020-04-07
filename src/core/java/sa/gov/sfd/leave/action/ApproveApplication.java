package sa.gov.sfd.leave.action;

import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.domain.path.ApprovalPathService;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupService;
import sa.gov.sfd.leave.domain.workflow.WorkflowService;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.model.EmployeeApprovalPath;
import sa.gov.sfd.leave.model.PermissionsGroup;
import sa.gov.sfd.leave.model.Workflow;

import java.time.LocalDateTime;

/**
 * @author malsharhan@sfd.gov.sa
 * @version 1.0
 */

public class ApproveApplication {

    private final ApplicationService applicationService;

    private final ApprovalPathService approvalPathService;

    private final WorkflowService workflowService;



    public ApproveApplication(ApplicationService applicationService
            , ApprovalPathService approvalPathService
            , WorkflowService workflowService) {
        this.applicationService = applicationService;
        this.approvalPathService = approvalPathService;
        this.workflowService = workflowService;
    }


    /**
     * Add new application transaction with approving action from permit employee, also check for the next step of approval
     * from workflow service, and add the permission group id to the application with status(1) which mean approved
     *
     * @param application is the application which required approving
     */
    @Transactional
    public void approve(Application application) {

        EmployeeApprovalPath path = approvalPathService.findByUserNid(application.getUserNid());
        Workflow workflow = workflowService.findWorkflowById(path.getWorkflow(), application.getWorkflowPriority() + 1);
//        PermissionsGroup group = permissionsGroupService.findByPermissionId(workflow.getPermissionsGroup());

        application.setWorkflow(workflow.getId());
        application.setWorkflowPriority(application.getWorkflowPriority() + 1);
        application.setCreatedDate(LocalDateTime.now());
        application.setStatus((short) 1);
        applicationService.approve(application);
    }
}
