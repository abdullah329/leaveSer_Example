package sa.gov.sfd.leave.action;

import org.springframework.transaction.annotation.Transactional;
import sa.gov.sfd.leave.domain.application.ApplicationService;
import sa.gov.sfd.leave.model.Application;

import java.time.LocalDateTime;
/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public class RejectApplication {

    private final ApplicationService applicationService;


    public RejectApplication(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * Reject leaving application from permit employee
     * @param application
     */
    @Transactional
    public void reject(Application application) {

        application.setCreatedDate(LocalDateTime.now());
        application.setWorkflowPriority(-1);
        application.setStatus((short) 3);
        applicationService.reject(application);
    }

}
