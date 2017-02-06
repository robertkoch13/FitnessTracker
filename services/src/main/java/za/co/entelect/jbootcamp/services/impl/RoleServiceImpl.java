package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.persistence.RoleRepository;
import za.co.entelect.jbootcamp.services.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public List<Role> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<Role> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return roleRepository.count();
    }

    @Override
    @Transactional
    public Role create(Role object) {
        return roleRepository.save(object);
    }

    @Override
    @Transactional
    public Role update(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public Role addPermissionToRole(String roleName, String permissionName) {
        Role role = roleRepository.findByName(roleName);
        role.getPermission().add(new Permission(permissionName));
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
