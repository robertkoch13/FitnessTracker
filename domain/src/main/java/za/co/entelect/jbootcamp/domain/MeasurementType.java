package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="measurement_type")
public class MeasurementType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="measurement_type_id")
    private int measurementTypeId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_of_measurement_id", nullable = false)
    private UnitOfMeasurement unitOfMeasurement;

    @Column(name="default_accuracy")
    private double defaultAccuracy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "measurement_frequency_id", nullable = false)
    private MeasurementFrequency measurementFrequency;

    public MeasurementType() {}

    public MeasurementType(int measurementTypeId, String name, UnitOfMeasurement unitOfMeasurement, double defaultAccuracy, MeasurementFrequency measurementFrequency) {
        this.measurementTypeId = measurementTypeId;
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.defaultAccuracy = defaultAccuracy;
        this.measurementFrequency = measurementFrequency;
    }

    public int getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(int measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public double getDefaultAccuracy() {
        return defaultAccuracy;
    }

    public void setDefaultAccuracy(double defaultAccuracy) {
        this.defaultAccuracy = defaultAccuracy;
    }

    public MeasurementFrequency getMeasurementFrequency() {
        return measurementFrequency;
    }

    public void setMeasurementFrequency(MeasurementFrequency measurementFrequency) {
        this.measurementFrequency = measurementFrequency;
    }

    @Override
    public String toString() {
        return "MeasurementType{" +
                "name='" + name + '\'' +
                ", unitOfMeasurement=" + unitOfMeasurement +
                ", defaultAccuracy=" + defaultAccuracy +
                ", measurementFrequency=" + measurementFrequency +
                '}';
    }
}
