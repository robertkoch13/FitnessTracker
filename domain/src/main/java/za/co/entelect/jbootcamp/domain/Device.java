package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="device")
public class Device implements java.io.Serializable {

    @Id
    @Column(name="device_id")
    private int deviceId;

    @Column(name="device_name")
    private String deviceName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_manufacturer_id", nullable = false)
    private DeviceManufacturer deviceManufacturer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_type_id", nullable = false)
    private DeviceType deviceType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="device_measurement_types",
            joinColumns=@JoinColumn(name="device_id"),
            inverseJoinColumns=@JoinColumn(name="measurement_type_id"))
    private List<MeasurementType> measurementTypes = new ArrayList<>();

    private String model;

    public Device() {}

    public Device(int deviceId, String deviceName, DeviceManufacturer deviceManufacturer, DeviceType deviceType, List<MeasurementType> measurementTypes, String model) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceManufacturer = deviceManufacturer;
        this.deviceType = deviceType;
        this.measurementTypes = measurementTypes;
        this.model = model;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceManufacturer getDeviceManufacturer() {
        return deviceManufacturer;
    }

    public void setDeviceManufacturer(DeviceManufacturer deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public List<MeasurementType> getMeasurementTypes() {
        return measurementTypes;
    }

    public void setMeasurementTypes(List<MeasurementType> measurementTypes) {
        this.measurementTypes = measurementTypes;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceManufacturer=" + deviceManufacturer +
                '}';
    }
}
