package sa.gov.sfd.leave.domain.permissions;


import com.fasterxml.jackson.databind.JsonNode;
import sa.gov.sfd.leave.model.PermissionsGroup;

import java.util.List;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public interface PermissionsGroupService {

    /**
     * Retrieve all permission groups
     * @return list of permissions group object
     */
    List<PermissionsGroup> findAllPermissions();

    /**
     * Retrive all employee under the same permission group
     * @param permissionsGroup permissions group id
     * @return JSON object has employee national id
     */
    JsonNode getAllEmployeesByPermission(Long permissionsGroup);

    /**
     * Retrieve Permissions group object by id
     * @param id permissions group id
     * @return permissions group object
     */
    PermissionsGroup findByPermissionId(Long id);

    /**
     * Retrieve list Permissions group objects by employee national Id
     * @param userNid employee national Id
     * @return list permissions group object
     */
    List<PermissionsGroup> findByEmployeeId(Integer userNid);
}
