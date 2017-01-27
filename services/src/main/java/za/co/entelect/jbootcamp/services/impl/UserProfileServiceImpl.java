package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.persistence.PermissionRepository;
import za.co.entelect.jbootcamp.persistence.RoleRepository;
import za.co.entelect.jbootcamp.persistence.UserProfileRepository;
import za.co.entelect.jbootcamp.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileRepository userProfileRepository;
    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userProfileRepository = userProfileRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserProfile findUserProfileById(int id) {
        return userProfileRepository.findOne(id);
    }

    @Override
    public List<UserProfile> findUserProfileAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public Page<UserProfile> findUserProfileAll(Pageable pageable) {
        return userProfileRepository.findAll(pageable);
    }

    @Override
    public List<UserProfile> findUserProfileByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<UserProfile> findUserProfileByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countUserProfile() {
        return userProfileRepository.count();
    }

    @Override
    @Transactional
    public UserProfile createUserProfile(UserProfile object) {
        return userProfileRepository.save(object);
    }

    @Override
    @Transactional
    public UserProfile updateUserProfile(UserProfile object) {
        return userProfileRepository.save(object);
    }

    @Override
    public Role findRoleById(int id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public List<Role> findRoleAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> findRoleAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public List<Role> findRoleByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<Role> findRoleByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countRole() {
        return roleRepository.count();
    }

    @Override
    @Transactional
    public Role createRole(Role object) {
        return roleRepository.save(object);
    }

    @Override
    @Transactional
    public Role updateRole(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public Permission findPermissionById(int id) {
        return permissionRepository.findOne(id);
    }

    @Override
    public List<Permission> findPermissionAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Page<Permission> findPermissionAll(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public List<Permission> findPermissionByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<Permission> findPermissionByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countPermission() {
        return permissionRepository.count();
    }

    @Override
    @Transactional
    public Permission createPermission(Permission object) {
        return permissionRepository.save(object);
    }

    @Override
    @Transactional
    public Permission updatePermission(Permission object) {
        return permissionRepository.save(object);
    }
}
