package sa.gov.sfd.leave.action;

import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.model.Application;

import java.util.List;

public class GetAllEmployeeApplication {

    private final ApplicationService applicationService;

    public GetAllEmployeeApplication(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    public List<Application> getAll(Integer userNid){
        return applicationService.findByUserNid(userNid);
    }
}
