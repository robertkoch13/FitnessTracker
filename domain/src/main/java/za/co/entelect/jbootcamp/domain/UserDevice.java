package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="user_device")
public class UserDevice implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_device_id")
    private int id;

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

    public UserDevice(int id, Device device, String name, String serialNumber, boolean isActive) {
        this.id = id;
        this.device = device;
        this.name = name;
        this.serialNumber = serialNumber;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserDevice{" +
                "device=" + device +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
