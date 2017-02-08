package za.co.entelect.jbootcamp.models;

public class UserDeviceModel {
    private int deviceId;
    private String name;
    private String serialNumber;
    private boolean active;

    public UserDeviceModel() {}

    public UserDeviceModel(int deviceId, String name, String serialNumber, boolean active) {
        this.deviceId = deviceId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.active = active;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }
}
