package za.co.entelect.jbootcamp.models;

import za.co.entelect.jbootcamp.domain.UserProfile;

public class EditUser {
    private String firstName;
    private String lastName;
    private String username;
    private int id;

    public EditUser() {}

    public EditUser(UserProfile userProfile) {
        this.firstName = userProfile.getFirstName();
        this.lastName = userProfile.getLastName();
        this.username = userProfile.getUsername();
        this.id = userProfile.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
