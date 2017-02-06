package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.Role;

import java.util.List;

public interface RoleService {
    Role findById(int id);
    List<Role> findAll();
    Page<Role> findAll(Pageable pageable);
    List<Role> findByProperty(String property, String searchCriteria);
    Page<Role> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    Role create(Role object);
    Role update(Role object);
    List<String> getSearchProperties();
    Role addPermissionToRole(String roleName, String permissionName);
    Role findByName(String name);
}
