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
import java.util.Random;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public class AddNewApplication {

    private final ApplicationService applicationService;


    private final ApprovalPathService approvalPathService;

    private final WorkflowService workflowService;



    public AddNewApplication(ApplicationService applicationService
            , ApprovalPathService approvalPathService, WorkflowService workflowService) {
        this.applicationService = applicationService;
        this.approvalPathService = approvalPathService;
        this.workflowService = workflowService;

    }

    /**
     * Create a leaving application for employee with initial status(0) and workflow priority(1) which mean the first
     * one in approval process.
     * Next required permission group will add to this application to allow them to take an action for this application
     * @param application is an initial leaving request from an employee
     */
    @Transactional
    public Long addNewApplication(Application application) {

        EmployeeApprovalPath path = approvalPathService.findByUserNid(application.getUserNid());
        Workflow workflow = workflowService.findWorkflowById(path.getWorkflow(), 1);
//        PermissionsGroup group = permissionsGroupService.findByPermissionId(workflow.getPermissionsGroup());

        application.setId(new Random().nextLong());
        application.setStatus((short) 0);
        application.setWorkflow(workflow.getId());
        application.setWorkflowPriority(1);
        application.setCreatedDate(LocalDateTime.now());
        application.setRequestDateAndTime(LocalDateTime.now());
        return applicationService.addNewApplication(application);
    }


}
