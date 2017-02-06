package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.services.UserProfileService;

@Component
public class UserProfileFormatter extends GenericDomainFormatter<UserProfile, UserProfileService> {

    @Autowired
    public UserProfileFormatter(UserProfileService service) {
        super();
        this.service = service;
    }
}
