package za.co.entelect.jbootcamp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import za.co.entelect.jbootcamp.enums.Gender;
import za.co.entelect.jbootcamp.enums.SystemOfMeasurement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_fitness_profile")
public class UserFitnessProfile implements java.io.Serializable {

    @Id
    @Column(name = "user_id")
    private int id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name="system_of_measurement_preference")
    @Enumerated(EnumType.STRING)
    private SystemOfMeasurement systemOfMeasurementPreference;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFitnessProfile", cascade = {CascadeType.ALL})
    private List<UserDevice> userDevices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFitnessProfile", cascade = {CascadeType.ALL})
    private List<UserGoal> userGoals = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFitnessProfile", cascade = {CascadeType.ALL})
    private List<UserFitnessMeasurement> userFitnessMeasurements = new ArrayList<>();

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public UserFitnessProfile() {}

    public UserFitnessProfile(Gender gender, Date dateOfBirth, SystemOfMeasurement systemOfMeasurementPreference, UserProfile userProfile) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
        this.userProfile = userProfile;
    }

    public UserFitnessProfile(int id, Gender gender, Date dateOfBirth, SystemOfMeasurement systemOfMeasurementPreference, List<UserDevice> userDevices, List<UserGoal> userGoals, List<UserFitnessMeasurement> userFitnessMeasurements, UserProfile userProfile) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public SystemOfMeasurement getSystemOfMeasurementPreference() {
        return systemOfMeasurementPreference;
    }

    public void setSystemOfMeasurementPreference(SystemOfMeasurement systemOfMeasurementPreference) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserFitnessProfile that = (UserFitnessProfile) o;

        return new EqualsBuilder()
                .append(gender, that.gender)
                .append(dateOfBirth, that.dateOfBirth)
                .append(systemOfMeasurementPreference, that.systemOfMeasurementPreference)
                .append(userProfile, that.userProfile)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(gender)
                .append(dateOfBirth)
                .append(systemOfMeasurementPreference)
                .append(userProfile)
                .toHashCode();
    }
}
