package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_fitness_profile")
public class UserFitnessProfile implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

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
    private UserProfile userProfile;

    public UserFitnessProfile() {}

    public UserFitnessProfile(String gender, Date dateOfBirth, String systemOfMeasurementPreference, UserProfile userProfile) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
        this.userProfile = userProfile;
    }

    public UserFitnessProfile(int id, String gender, Date dateOfBirth, String systemOfMeasurementPreference, List<UserDevice> userDevices, List<UserGoal> userGoals, List<UserFitnessMeasurement> userFitnessMeasurements, UserProfile userProfile) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
        this.userDevices = userDevices;
        this.userGoals = userGoals;
        this.userFitnessMeasurements = userFitnessMeasurements;
        this.userProfile = userProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserFitnessProfile{" +
                "gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", systemOfMeasurementPreference='" + systemOfMeasurementPreference + '\'' +
                '}';
    }
}
