package sa.gov.sfd.leave.model;


/**
 * Employee Approval Path Object which contain employee national ID and workflow ID
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public class EmployeeApprovalPath {

    private Integer userNid;

    private Long workflow;

    public Integer getUserNid() {
        return userNid;
    }

    public void setUserNid(Integer userNid) {
        this.userNid = userNid;
    }

    public Long getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Long workflow) {
        this.workflow = workflow;
    }
}
