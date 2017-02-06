package za.co.entelect.jbootcamp.services;

import za.co.entelect.jbootcamp.domain.UserProfile;

public interface UserProfileService extends GenericService<UserProfile> {
    UserProfile findByUsername(String username);
    UserProfile createUserProfile(String username, String password, String firstname, String lastname);
    UserProfile addRoleToUserProfile(UserProfile userProfile, String role);
    UserProfile addRoleToUserProfile(String username, String role);
}
