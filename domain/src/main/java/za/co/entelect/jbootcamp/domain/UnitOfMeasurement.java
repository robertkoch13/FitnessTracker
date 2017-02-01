package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="unit_of_measurement")
public class UnitOfMeasurement implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unit_of_measurement_id")
    private int id;

    @Column(name="unit_of_measurement")
    private String unitOfMeasurement;

    public UnitOfMeasurement() {}

    public UnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public String toString() {
        return "UnitOfMeasurement{" +
                "unitOfMeasurement='" + unitOfMeasurement + '\'' +
                '}';
    }
}
