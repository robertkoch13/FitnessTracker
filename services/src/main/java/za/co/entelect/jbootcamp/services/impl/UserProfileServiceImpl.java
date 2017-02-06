package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.persistence.UserProfileRepository;
import za.co.entelect.jbootcamp.services.RoleService;
import za.co.entelect.jbootcamp.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private RoleService roleService;
    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(RoleService roleService, UserProfileRepository userProfileRepository) {
        this.roleService = roleService;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile findById(int id) {
        return userProfileRepository.findOne(id);
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
        return userProfileRepository.findAll(pageable);
    }

    @Override
    public List<UserProfile> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<UserProfile> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return userProfileRepository.count();
    }

    @Override
    @Transactional
    public UserProfile create(UserProfile object) {
        return userProfileRepository.save(object);
    }

    @Override
    @Transactional
    public UserProfile update(UserProfile object) {
        return userProfileRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public UserProfile findByUsername(String username) {
        return userProfileRepository.findByUsername(username);
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
