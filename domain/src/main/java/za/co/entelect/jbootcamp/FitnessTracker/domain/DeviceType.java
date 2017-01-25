package za.co.entelect.jbootcamp.FitnessTracker.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="device_type")
public class DeviceType implements java.io.Serializable {

    @Id
    @Column(name="device_type_id")
    private int deviceTypeId;

    @Column(name="device_type")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deviceType")
    private List<Device> devices = new ArrayList<>();

    public DeviceType() {}

    public DeviceType(int deviceTypeId, String name) {
        this.deviceTypeId = deviceTypeId;
        this.name = name;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
