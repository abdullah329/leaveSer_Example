package sa.gov.sfd.leave.action;

import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupService;
import sa.gov.sfd.leave.domain.workflow.WorkflowService;
import sa.gov.sfd.leave.model.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author malsharhan@sfd.gov.sa
 * @version 1.0
 */
public class GetApplicationsToMakeAction {

    private final ApplicationService applicationService;
    private final PermissionsGroupService groupService;
    private final WorkflowService workflowService;

    public GetApplicationsToMakeAction(ApplicationService applicationService, PermissionsGroupService groupService,
                                       WorkflowService workflowService) {
        this.applicationService = applicationService;
        this.groupService = groupService;
        this.workflowService = workflowService;
    }

    /**
     * Retrieve all applications with permissions which required an action for all employee who have permission id
     *
     * @param userid employee national id
     * @return list of application with workflow DTO
     */
    public List<ApplicationWithPermissionDTO> getApplicationByPermissionId(Integer userid) {
        List<PermissionsGroup> permissions = groupService.findByEmployeeId(userid);

        List<Workflow> workflow = workflowService.findByGroupIds(permissions
                .stream()
                .map(BaseObject::getId)
                .collect(Collectors.toList()));

        List<Application> applicationList = applicationService
                .findByWorkflowId(workflow
                        .stream()
                        .map(BaseObject::getId)
                        .collect(Collectors.toList()));
        return convertToApplicationWithPermissions(workflow, applicationList);
    }


    private List<ApplicationWithPermissionDTO> convertToApplicationWithPermissions(List<Workflow> workflow, List<Application> applicationList) {

        List<Application> cleanApplication = applicationList.stream()
                .filter(x -> workflow.stream()
                        .anyMatch(m -> m.getId().equals(x.getWorkflow()) &&
                                m.getPriority().equals(x.getWorkflowPriority()))).collect(Collectors.toList());

        return cleanApplication.stream().map(
                x -> {
                    return new ApplicationWithPermissionDTO(x.getId()
                            , x.getWorkflowPriority()
                            , x.getUserNid()
                            , x.getStartDateAg()
                            , x.getStartDateAh()
                            , x.getDuration()
                            , x.getRequestDateAndTime()
                            , x.getStatus()
                            , x.getWorkflow()
                            , x.getType()
                            , workflow.stream().filter(i -> i.getId().equals(x.getWorkflow()) &&
                            i.getPriority().equals(x.getWorkflowPriority())).findFirst().get().getAction()
                    );
                }).collect(Collectors.toList());
    }

}
