package za.co.entelect.jbootcamp.models;

public class UserDeviceModel {
    private int deviceId;
    private String name;
    private String serialNumber;
    private boolean isActive;

    public UserDeviceModel() {}

    public UserDeviceModel(int deviceId, String name, String serialNumber, boolean isActive) {
        this.deviceId = deviceId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.isActive = isActive;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
