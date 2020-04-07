package sa.gov.sfd.leave.domain.permissions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import sa.gov.sfd.leave.model.PermissionsGroup;

import java.util.List;

public class PermissionsGroupServiceImpl implements PermissionsGroupService {

    private final PermissionsGroupDao dao;

    public PermissionsGroupServiceImpl(PermissionsGroupDao dao) {
        this.dao = dao;
    }

    @Override
    public List<PermissionsGroup> findAllPermissions() {
        return dao.findAll();
    }

    @Override
    public JsonNode getAllEmployeesByPermission(Long permissionsGroup) {
        try {
            return dao.findById(permissionsGroup).orElseThrow(IllegalArgumentException::new).getEmployees();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PermissionsGroup findByPermissionId(Long id) {
        return dao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<PermissionsGroup> findByEmployeeId(Integer userNid) {
        return dao.findByUserNid(userNid);
    }
}
