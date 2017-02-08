package za.co.entelect.jbootcamp.models;

import org.springframework.format.annotation.DateTimeFormat;
import za.co.entelect.jbootcamp.enums.Gender;
import za.co.entelect.jbootcamp.enums.SystemOfMeasurement;

import java.util.Date;

public class UserFitnessProfileModel {
    private int userId;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dob;
    private SystemOfMeasurement systemOfMeasurementPreference;

    public UserFitnessProfileModel() {
    }

    public UserFitnessProfileModel(int userId, Gender gender, Date dob, SystemOfMeasurement systemOfMeasurementPreference) {
        this.userId = userId;
        this.gender = gender;
        this.dob = dob;
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public SystemOfMeasurement getSystemOfMeasurementPreference() {
        return systemOfMeasurementPreference;
    }

    public void setSystemOfMeasurementPreference(SystemOfMeasurement systemOfMeasurementPreference) {
        this.systemOfMeasurementPreference = systemOfMeasurementPreference;
    }
}
