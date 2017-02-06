package za.co.entelect.jbootcamp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="measurement_frequency")
public class MeasurementFrequency implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="measurement_frequency_id")
    private int id;

    private String frequency;

    public MeasurementFrequency() {}

    public MeasurementFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MeasurementFrequency that = (MeasurementFrequency) o;

        return new EqualsBuilder()
                .append(frequency, that.frequency)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(frequency)
                .toHashCode();
    }
}
