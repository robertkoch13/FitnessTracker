package za.co.entelect.jbootcamp.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.persistence.PermissionRepository;
import za.co.entelect.jbootcamp.services.PermissionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, PermissionRepository> implements PermissionService {

    @Override
    public Page<Permission> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
