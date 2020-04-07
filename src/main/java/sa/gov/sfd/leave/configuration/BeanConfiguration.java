package sa.gov.sfd.leave.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;
import sa.gov.sfd.leave.action.*;
import sa.gov.sfd.leave.domain.application.ApplicationDao;
import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.domain.application.ApplicationServiceImpl;
import sa.gov.sfd.leave.domain.application.ApplicationValidation;
import sa.gov.sfd.leave.domain.balance.BalanceDao;
import sa.gov.sfd.leave.domain.balance.BalanceService;
import sa.gov.sfd.leave.domain.balance.BalanceServiceImpl;
import sa.gov.sfd.leave.domain.balance.BalanceValidation;
import sa.gov.sfd.leave.domain.path.ApprovalPathDao;
import sa.gov.sfd.leave.domain.path.ApprovalPathService;
import sa.gov.sfd.leave.domain.path.ApprovalPathServiceImpl;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupDao;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupService;
import sa.gov.sfd.leave.domain.permissions.PermissionsGroupServiceImpl;
import sa.gov.sfd.leave.domain.workflow.WorkflowDao;
import sa.gov.sfd.leave.domain.workflow.WorkflowService;
import sa.gov.sfd.leave.domain.workflow.WorkflowServiceImpl;


@Configuration
public class BeanConfiguration {


    //--------------------- LeaveApplicationsDao Registration ------------------------

    @Bean
    public ApplicationValidation applicationValidation(ApplicationDao dao){
        return new ApplicationValidation(dao);
    }

    @Bean
    public ApplicationService applicationService(ApplicationDao dao, ApplicationValidation validation) {
        return new ApplicationServiceImpl(dao, validation);
    }


    @Bean
    public BalanceValidation balanceValidation(BalanceDao dao){
        return new BalanceValidation(dao);
    }

    @Bean
    public BalanceService balanceService(BalanceDao dao, BalanceValidation validation) {
        return new BalanceServiceImpl(dao, validation);
    }


    @Bean
    public ApprovalPathService approvalPathService(ApprovalPathDao dao) {
        return new ApprovalPathServiceImpl(dao);
    }

    @Bean
    public PermissionsGroupService permissionsGroupService(PermissionsGroupDao dao) {
        return new PermissionsGroupServiceImpl(dao);
    }

    @Bean
    public WorkflowService workflowService(WorkflowDao dao) {
        return new WorkflowServiceImpl(dao);
    }

    @Bean
    public AddNewApplication addEmployeeNewApplication(ApplicationService applicationService
            , ApprovalPathService approvalPathService
            , WorkflowService workflowService) {

        return new AddNewApplication(applicationService
                , approvalPathService, workflowService
                );
    }

    @Bean
    public ApproveApplication approveApplication(ApplicationService applicationService
            , ApprovalPathService approvalPathService
            , WorkflowService workflowService){

        return new ApproveApplication( applicationService
                ,  approvalPathService
                ,  workflowService);
    }



    @Bean
    public CancelApplication cancelApplication(ApplicationService applicationService
            , BalanceService balanceService){
        return new CancelApplication( applicationService
                ,  balanceService);
    }


    @Bean
    public ConfirmApplication confirmApplication(ApplicationService applicationService
            , BalanceService balanceService){
        return new ConfirmApplication( applicationService
                ,  balanceService);
    }


    @Bean
    public RejectApplication rejectApplication(ApplicationService applicationService){
        return new RejectApplication(applicationService);
    }


    @Bean
    public GetCurrentBalance getCurrentBalance(BalanceService balanceService){
        return new GetCurrentBalance(balanceService);
    }

    @Bean
    public GetApplicationsToMakeAction getApplicationToMakeAction(ApplicationService applicationService
    , PermissionsGroupService groupService, WorkflowService workflowService){
        return new GetApplicationsToMakeAction(applicationService, groupService, workflowService);
    }

    @Bean
    public GetOneApplicationToAction getOneApplicationToAction(ApplicationService applicationService){
        return new GetOneApplicationToAction(applicationService);
    }

    @Bean
    public GetPermissionsByID getPermissionsByID(PermissionsGroupService permissionsGroupService){
        return new GetPermissionsByID(permissionsGroupService);
    }

    @Bean
    public GetAllEmployeeApplication getAllEmployeeApplication(ApplicationService applicationService){
        return new GetAllEmployeeApplication(applicationService);
    }
}
