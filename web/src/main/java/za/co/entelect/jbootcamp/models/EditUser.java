package za.co.entelect.jbootcamp.models;

import java.util.ArrayList;
import java.util.List;

public class EditUser {
    private String firstName;
    private String lastName;
    private String username;
    private int id;
    private List<String> roles = new ArrayList<>();

    public EditUser() {}

    public EditUser(String firstName, String lastName, String username, int id, List<String> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.id = id;
        this.roles = roles;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
