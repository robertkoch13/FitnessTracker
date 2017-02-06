package za.co.entelect.jbootcamp.services;

import za.co.entelect.jbootcamp.domain.Role;

public interface RoleService extends GenericService<Role> {
    Role addPermissionToRole(String roleName, String permissionName);
    Role findByName(String name);
}
