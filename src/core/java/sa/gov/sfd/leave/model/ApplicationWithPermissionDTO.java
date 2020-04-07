package sa.gov.sfd.leave.model;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ApplicationWithPermissionDTO extends Application {

    private String action;

    public ApplicationWithPermissionDTO(Long id,
                                        Integer workflowPriority,
                                        Integer userNid,
                                        LocalDate startDateAg,
                                        String startDateAh,
                                        @Positive Short duration,
                                        LocalDateTime requestDateAndTime,
                                        Short status,
                                        Long permissionsGroupId,
                                        @Positive Short type,
                                        String action) {

        super(id, workflowPriority, userNid, startDateAg, startDateAh, duration, requestDateAndTime, status, permissionsGroupId, type);
        setAction(action);
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
