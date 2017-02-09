package za.co.entelect.jbootcamp.models;

import org.springframework.format.annotation.DateTimeFormat;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementsFrequency;

import java.util.Date;

public class DashboardFilterObjectModel {
    private String measurementType;
    private UserFitnessMeasurementsFrequency userFitnessMeasurementsFrequency;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fromDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date toDate;

    public DashboardFilterObjectModel() {
    }

    public DashboardFilterObjectModel(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DashboardFilterObjectModel(String measurementType, UserFitnessMeasurementsFrequency userFitnessMeasurementsFrequency, Date fromDate, Date toDate) {
        this.measurementType = measurementType;
        this.userFitnessMeasurementsFrequency = userFitnessMeasurementsFrequency;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public UserFitnessMeasurementsFrequency getUserFitnessMeasurementsFrequency() {
        return userFitnessMeasurementsFrequency;
    }

    public void setUserFitnessMeasurementsFrequency(UserFitnessMeasurementsFrequency userFitnessMeasurementsFrequency) {
        this.userFitnessMeasurementsFrequency = userFitnessMeasurementsFrequency;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
