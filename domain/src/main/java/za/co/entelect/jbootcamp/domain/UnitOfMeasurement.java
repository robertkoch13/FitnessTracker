package za.co.entelect.jbootcamp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="unit_of_measurement")
public class UnitOfMeasurement implements java.io.Serializable, GenericDomainModelInterface {

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
        return unitOfMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UnitOfMeasurement that = (UnitOfMeasurement) o;

        return new EqualsBuilder()
                .append(unitOfMeasurement, that.unitOfMeasurement)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(unitOfMeasurement)
                .toHashCode();
    }
}
