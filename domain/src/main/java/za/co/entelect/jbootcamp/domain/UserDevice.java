package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="user_device")
public class UserDevice implements java.io.Serializable {

    @Id
    @Column(name="user_device_id")
    private int userDeviceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(name="descriptive_name")
    private String name;

    @Column(name="serial_number")
    private String serialNumber;

    @Column(name="active")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserFitnessProfile userFitnessProfile;

    public UserDevice() {}

    public UserDevice(int userDeviceId, Device device, String name, String serialNumber, boolean isActive) {
        this.userDeviceId = userDeviceId;
        this.device = device;
        this.name = name;
        this.serialNumber = serialNumber;
        this.isActive = isActive;
    }

    public int getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(int userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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

    public UserFitnessProfile getUserFitnessProfile() {
        return userFitnessProfile;
    }

    public void setUserFitnessProfile(UserFitnessProfile userFitnessProfile) {
        this.userFitnessProfile = userFitnessProfile;
    }
}
