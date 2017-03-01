package za.co.entelect.jbootcamp.services.model;

public enum UserFitnessMeasurementsFrequency {
    Daily("Daily"), Monthly("Monthly");

    String userFitnessMeasurementsFrequency;

    UserFitnessMeasurementsFrequency(String userFitnessMeasurementsFrequency) {
        this.userFitnessMeasurementsFrequency = userFitnessMeasurementsFrequency;
    }

    public String getUserFitnessMeasurementsFrequency() {
        return userFitnessMeasurementsFrequency;
    }

}
