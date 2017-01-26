package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="device_type")
public class DeviceType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="device_type_id")
    private int id;

    @Column(name="device_type")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deviceType")
    private List<Device> devices = new ArrayList<>();

    public DeviceType() {}

    public DeviceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DeviceType{" +
                "name='" + name + '\'' +
                '}';
    }
}
