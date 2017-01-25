package za.co.entelect.jbootcamp.FitnessTracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit_of_measurement")
public class UnitOfMeasurement implements java.io.Serializable {

    @Id
    @Column(name="unit_of_measurement_id")
    private int unitOfMeasurementId;

    @Column(name="unit_of_measurement")
    private String unitOfMeasurement;

    public UnitOfMeasurement() {}

    public UnitOfMeasurement(int unitOfMeasurementId, String unitOfMeasurement) {
        this.unitOfMeasurementId = unitOfMeasurementId;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getUnitOfMeasurementId() {
        return unitOfMeasurementId;
    }

    public void setUnitOfMeasurementId(int unitOfMeasurementId) {
        this.unitOfMeasurementId = unitOfMeasurementId;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
