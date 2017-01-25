package za.co.entelect.jbootcamp.FitnessTracker.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_fitness_measurement")
public class UserFitnessMeasurement implements java.io.Serializable {

    @Id
    @Column(name="user_fitness_measurement_id")
    private int userFitnessMeasurementId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_device_id", nullable = false)
    private UserDevice userDevice;

    private Date dateLogged;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "measurement_type_id", nullable = false)
    private MeasurementType measurementType;

    @Column(name="measurement_value")
    private double measurementValue;

    @Column(name="measurement_accuracy")
    private double measurementAccuracy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserFitnessProfile userFitnessProfile;

    public UserFitnessMeasurement() {}

    public UserFitnessMeasurement(int userFitnessMeasurementId, UserDevice userDevice, Date dateLogged, MeasurementType measurementType, double measurementValue, double measurementAccuracy) {
        this.userFitnessMeasurementId = userFitnessMeasurementId;
        this.userDevice = userDevice;
        this.dateLogged = dateLogged;
        this.measurementType = measurementType;
        this.measurementValue = measurementValue;
        this.measurementAccuracy = measurementAccuracy;
    }

    public int getUserFitnessMeasurementId() {
        return userFitnessMeasurementId;
    }

    public void setUserFitnessMeasurementId(int userFitnessMeasurementId) {
        this.userFitnessMeasurementId = userFitnessMeasurementId;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public double getMeasurementAccuracy() {
        return measurementAccuracy;
    }

    public void setMeasurementAccuracy(double measurementAccuracy) {
        this.measurementAccuracy = measurementAccuracy;
    }

    public UserFitnessProfile getUserFitnessProfile() {
        return userFitnessProfile;
    }

    public void setUserFitnessProfile(UserFitnessProfile userFitnessProfile) {
        this.userFitnessProfile = userFitnessProfile;
    }
}
