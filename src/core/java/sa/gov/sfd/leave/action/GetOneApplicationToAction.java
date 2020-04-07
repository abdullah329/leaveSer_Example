package sa.gov.sfd.leave.action;

import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.model.Application;

public class GetOneApplicationToAction {

    private final ApplicationService applicationService;

    public GetOneApplicationToAction(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public Application getApplication (Long id, Integer priority){
        return applicationService.findById(id,priority);
    }
}
