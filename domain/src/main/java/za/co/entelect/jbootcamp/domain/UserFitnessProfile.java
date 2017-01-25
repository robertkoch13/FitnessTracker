package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_fitness_profile")
public class UserFitnessProfile implements java.io.Serializable {

    @Id
    @Column(name="user_id")
    private int userId;

    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name="system_of_measurement_preference")
    private String systemOfMeasurementPreference;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFitnessProfile")
    private List<UserDevice> userDevices = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="device_measurement_types",
            joinColumns=@JoinColumn(name="device_id"),
            inverseJoinColumns=@JoinColumn(name="measurement_type_id"))
    private List<UserGoal> userGoals = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFitnessProfile")
    private List<UserFitnessMeasurement> userFitnessMeasurements = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    public UserFitnessProfile() {}

    public UserFitnessProfile(int userId, String gender, Date dateOfBirth, String systemOfMeasurementPreference, User user) {
        this.userId = userId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
        this.user = user;
    }

    public UserFitnessProfile(int userId, String gender, Date dateOfBirth, String systemOfMeasurementPreference, List<UserDevice> userDevices, List<UserGoal> userGoals, List<UserFitnessMeasurement> userFitnessMeasurements, User user) {
        this.userId = userId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
        this.userDevices = userDevices;
        this.userGoals = userGoals;
        this.userFitnessMeasurements = userFitnessMeasurements;
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSystemOfMeasurementPreference() {
        return systemOfMeasurementPreference;
    }

    public void setSystemOfMeasurementPreference(String systemOfMeasurementPreference) {
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
    }

    public List<UserDevice> getUserDevices() {
        return userDevices;
    }

    public void setUserDevices(List<UserDevice> userDevices) {
        this.userDevices = userDevices;
    }

    public List<UserGoal> getUserGoals() {
        return userGoals;
    }

    public void setUserGoals(List<UserGoal> userGoals) {
        this.userGoals = userGoals;
    }

    public List<UserFitnessMeasurement> getUserFitnessMeasurements() {
        return userFitnessMeasurements;
    }

    public void setUserFitnessMeasurements(List<UserFitnessMeasurement> userFitnessMeasurements) {
        this.userFitnessMeasurements = userFitnessMeasurements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
