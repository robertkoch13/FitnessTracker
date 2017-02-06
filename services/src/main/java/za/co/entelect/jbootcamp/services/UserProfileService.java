package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile findById(int id);
    List<UserProfile> findAll();
    Page<UserProfile> findAll(Pageable pageable);
    List<UserProfile> findByProperty(String property, String searchCriteria);
    Page<UserProfile> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    UserProfile create(UserProfile object);
    UserProfile update(UserProfile object);
    List<String> getSearchProperties();
    UserProfile findByUsername(String username);
    UserProfile createUserProfile(String username, String password, String firstname, String lastname);
    UserProfile addRoleToUserProfile(UserProfile userProfile, String role);
    UserProfile addRoleToUserProfile(String username, String role);
}
