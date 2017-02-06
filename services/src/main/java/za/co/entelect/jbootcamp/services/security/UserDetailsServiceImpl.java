package za.co.entelect.jbootcamp.services.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import za.co.entelect.jbootcamp.domain.Permission;
import za.co.entelect.jbootcamp.domain.Role;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.persistence.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserDetailsServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        if( userProfile != null) {
            try {
                return buildSpringUserFromAppUser(userProfile);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private UserDetails buildSpringUserFromAppUser(UserProfile userProfile) throws NamingException {
        String username = userProfile.getUsername();
        String password = userProfile.getPassword();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<String> uniquePermissions = new ArrayList<>();
        for(Role role: userProfile.getRoles()) {
            for(Permission permission: role.getPermission()) {
                if(!uniquePermissions.contains(permission.getPermission())) {
                    uniquePermissions.add(permission.getPermission());
                }
            }
        }
        for(String permission: uniquePermissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        return new User(username, password, authorities);
    }
}
