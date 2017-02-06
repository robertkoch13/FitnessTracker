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
import za.co.entelect.jbootcamp.services.RoleService;
import za.co.entelect.jbootcamp.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileServiceImpl extends GenericServiceImpl<UserProfile, UserProfileRepository> implements UserProfileService {

    @Autowired
    private RoleService roleService;

    @Override
    public UserProfile findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Page<UserProfile> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    @Transactional
    public UserProfile createUserProfile(String username, String password, String firstname, String lastname) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("Standard"));
        return create(new UserProfile(username, password, firstname, lastname, roles));
    }

    @Override
    @Transactional
    public UserProfile addRoleToUserProfile(UserProfile userProfile, String role) {
        userProfile.getRoles().add(roleService.findByName(role));
        return update(userProfile);
    }

    @Override
    @Transactional
    public UserProfile addRoleToUserProfile(String username, String role) {
        return addRoleToUserProfile(findByUsername(username), role);
    }

}
