package za.co.entelect.jbootcamp.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import za.co.entelect.jbootcamp.domain.UserProfile;
import za.co.entelect.jbootcamp.services.UserProfileService;

import java.text.ParseException;
import java.util.Locale;

public class UserProfileFormatter implements Formatter<UserProfile> {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileFormatter() { super(); }

    public UserProfile parse(final String text, final Locale locale) throws ParseException {
        final Integer id = Integer.valueOf(text);
        return this.userProfileService.findById(id);
    }

    public String print(final UserProfile object, final Locale locale) {
        return (object != null ? Integer.toString(object.getId()) : "");
    }
}
