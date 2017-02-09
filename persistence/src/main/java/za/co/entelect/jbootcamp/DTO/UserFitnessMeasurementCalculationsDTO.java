package za.co.entelect.jbootcamp.DTO;

public class UserFitnessMeasurementCalculationsDTO {
    private String dateValue;
    private double maxValue;
    private double minValue;
    private double averageValue;

    public UserFitnessMeasurementCalculationsDTO() {
    }

    public UserFitnessMeasurementCalculationsDTO(String dateValue, double maxValue, double minValue, double averageValue) {
        this.dateValue = dateValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.averageValue = averageValue;
    }

    public String getDateValue() {
        return dateValue;
    }

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }
}
