package za.co.entelect.jbootcamp.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.persistence.PermissionRepository;
import za.co.entelect.jbootcamp.persistence.RoleRepository;
import za.co.entelect.jbootcamp.services.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, RoleRepository> implements RoleService {

    @Override
    public Page<Role> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public Role addPermissionToRole(String roleName, String permissionName) {
        Role role = repository.findByName(roleName);
        role.getPermission().add(new Permission(permissionName));
        repository.save(role);
        return role;
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
