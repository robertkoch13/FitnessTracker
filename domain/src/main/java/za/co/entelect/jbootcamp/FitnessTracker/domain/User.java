package za.co.entelect.jbootcamp.FitnessTracker.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User implements java.io.Serializable {

    @Id
    @Column(name="user_id")
    private int userId;

    private String username;

    private String password;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles = new ArrayList<>();

    public User() {}

    public User(int userId, String username, String password, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int userId, String username, String password, String firstName, String lastName, List<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
