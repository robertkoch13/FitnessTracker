package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.Permission;

import java.util.List;

public interface PermissionService {
    Permission findById(int id);
    List<Permission> findAll();
    Page<Permission> findAll(Pageable pageable);
    List<Permission> findByProperty(String property, String searchCriteria);
    Page<Permission> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    Permission create(Permission object);
    Permission update(Permission object);
    List<String> getSearchProperties();
}
