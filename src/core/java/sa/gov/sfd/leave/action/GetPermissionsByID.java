package sa.gov.sfd.leave.action;

import sa.gov.sfd.leave.domain.permissions.PermissionsGroupService;
import sa.gov.sfd.leave.model.PermissionsGroup;

public class GetPermissionsByID {

    private final PermissionsGroupService service;

    public GetPermissionsByID(PermissionsGroupService service) {
        this.service = service;
    }


    public PermissionsGroup getByPermissionID(long id){
        return service.findByPermissionId(id);
    }
}
