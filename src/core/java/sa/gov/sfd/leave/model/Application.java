package sa.gov.sfd.leave.model;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Application Transaction Object
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */
public class Application extends BaseObject{


    private Integer workflowPriority;

    private Integer userNid;

    private LocalDate startDateAg;

    private String startDateAh;

    @Positive
    private Short duration;

    private LocalDateTime requestDateAndTime;


    private Short status;

    private Long workflow;

    @Positive
    private Short type;

    public Application() {
    }

    public Application(Long id,Integer workflowPriority, Integer userNid, LocalDate startDateAg, String startDateAh, @Positive Short duration, LocalDateTime requestDateAndTime, Short status, Long permissionsGroupId, @Positive Short type) {
        this.setId(id);
        this.workflowPriority = workflowPriority;
        this.userNid = userNid;
        this.startDateAg = startDateAg;
        this.startDateAh = startDateAh;
        this.duration = duration;
        this.requestDateAndTime = requestDateAndTime;
        this.status = status;
        this.workflow = permissionsGroupId;
        this.type = type;
    }

    public Integer getWorkflowPriority() {
        return workflowPriority;
    }

    public void setWorkflowPriority(Integer workflowPriority) {
        this.workflowPriority = workflowPriority;
    }

    public Integer getUserNid() {
        return userNid;
    }

    public void setUserNid(Integer userNid) {
        this.userNid = userNid;
    }

    public LocalDate getStartDateAg() {
        return startDateAg;
    }

    public void setStartDateAg(LocalDate startDateAg) {
        this.startDateAg = startDateAg;
    }

    public String getStartDateAh() {
        return startDateAh;
    }

    public void setStartDateAh(String startDateAh) {
        this.startDateAh = startDateAh;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public LocalDateTime getRequestDateAndTime() {
        return requestDateAndTime;
    }

    public void setRequestDateAndTime(LocalDateTime requestDateAndTime) {
        this.requestDateAndTime = requestDateAndTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Long workflow) {
        this.workflow = workflow;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}
