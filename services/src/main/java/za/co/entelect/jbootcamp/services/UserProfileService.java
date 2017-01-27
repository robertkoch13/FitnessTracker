package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.domain.UserProfile;
import java.util.List;

public interface UserProfileService {
    UserProfile findUserProfileById(int id);
    List<UserProfile> findUserProfileAll();
    Page<UserProfile> findUserProfileAll(Pageable pageable);
    List<UserProfile> findUserProfileByProperty(String property, String searchCriteria);
    Page<UserProfile> findUserProfileByProperty(String property, String searchCriteria, Pageable pageable);
    long countUserProfile();
    UserProfile createUserProfile(UserProfile object);
    UserProfile updateUserProfile(UserProfile object);

    Role findRoleById(int id);
    Role findRoleByName(String name);
    List<Role> findRoleAll();
    Page<Role> findRoleAll(Pageable pageable);
    List<Role> findRoleByProperty(String property, String searchCriteria);
    Page<Role> findRoleByProperty(String property, String searchCriteria, Pageable pageable);
    long countRole();
    Role createRole(Role object);
    Role updateRole(Role object);

    Permission findPermissionById(int id);
    List<Permission> findPermissionAll();
    Page<Permission> findPermissionAll(Pageable pageable);
    List<Permission> findPermissionByProperty(String property, String searchCriteria);
    Page<Permission> findPermissionByProperty(String property, String searchCriteria, Pageable pageable);
    long countPermission();
    Permission createPermission(Permission object);
    Permission updatePermission(Permission object);

}
