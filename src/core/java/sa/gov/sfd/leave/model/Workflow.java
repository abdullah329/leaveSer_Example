package sa.gov.sfd.leave.model;

/**
 * Workflow Object
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */
public class Workflow extends BaseObject{


    private Integer priority;

    private Long permissionsGroup;

    private String action;

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getPermissionsGroup() {
        return permissionsGroup;
    }

    public void setPermissionsGroup(Long permissionsGroup) {
        this.permissionsGroup = permissionsGroup;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
