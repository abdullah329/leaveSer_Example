package sa.gov.sfd.leave.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * Permissions Type and Group name with employee list
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public class PermissionsGroup extends BaseObject{


    private String groupName;

    private String employees;

    private String permission;


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public JsonNode getEmployees() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(employees);
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public List<String> getPermission() {
        return Arrays.asList(permission.split(","));
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
