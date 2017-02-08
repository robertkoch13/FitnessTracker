package za.co.entelect.jbootcamp.enums;

public enum SystemOfMeasurement {
    Metric("Metric"), Imperial("Imperial");

    String systemOfMeasurement;

    private SystemOfMeasurement(String systemOfMeasurement) {
        this.systemOfMeasurement = systemOfMeasurement;
    }

    public String getSystemOfMeasurement() {
        return this.systemOfMeasurement;
    }


}
