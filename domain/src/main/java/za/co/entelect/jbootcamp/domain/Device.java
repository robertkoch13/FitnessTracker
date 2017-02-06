package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="device")
public class Device implements java.io.Serializable, GenericDomainModelInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="device_id")
    private int id;

    @Column(name="device_name")
    private String deviceName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_manufacturer_id", nullable = false)
    private DeviceManufacturer deviceManufacturer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_type_id", nullable = false)
    private DeviceType deviceType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name="device_measurement_types",
            joinColumns=@JoinColumn(name="device_id"),
            inverseJoinColumns=@JoinColumn(name="measurement_type_id"))
    private List<MeasurementType> measurementTypes = new ArrayList<>();

    private String model;

    public Device() {}

    public Device(String deviceName, DeviceManufacturer deviceManufacturer, DeviceType deviceType, List<MeasurementType> measurementTypes, String model) {
        this.deviceName = deviceName;
        this.deviceManufacturer = deviceManufacturer;
        this.deviceType = deviceType;
        this.measurementTypes = measurementTypes;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return String.format("%s %s %s %s", deviceManufacturer, deviceName, model, deviceType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(deviceName, device.deviceName)
                .append(deviceManufacturer, device.deviceManufacturer)
                .append(deviceType, device.deviceType)
                .append(model, device.model)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(deviceName)
                .append(deviceManufacturer)
                .append(deviceType)
                .append(model)
                .toHashCode();
    }
}
