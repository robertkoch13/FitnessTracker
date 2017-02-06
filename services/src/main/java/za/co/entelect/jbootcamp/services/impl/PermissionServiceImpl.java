package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.persistence.PermissionRepository;
import za.co.entelect.jbootcamp.services.PermissionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission findById(int id) {
        return permissionRepository.findOne(id);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Page<Permission> findAll(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public List<Permission> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<Permission> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return permissionRepository.count();
    }

    @Override
    @Transactional
    public Permission create(Permission object) {
        return permissionRepository.save(object);
    }

    @Override
    @Transactional
    public Permission update(Permission object) {
        return permissionRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
