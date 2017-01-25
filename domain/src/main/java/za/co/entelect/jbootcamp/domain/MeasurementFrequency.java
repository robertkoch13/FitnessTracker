package za.co.entelect.jbootcamp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="measurement_frequency")
public class MeasurementFrequency implements java.io.Serializable {

    @Id
    @Column(name="measurement_frequency_id")
    private int measurementFrequencyId;

    private String frequency;

    public MeasurementFrequency() {}

    public MeasurementFrequency(int measurementFrequencyId, String frequency) {
        this.measurementFrequencyId = measurementFrequencyId;
        this.frequency = frequency;
    }

    public int getMeasurementFrequencyId() {
        return measurementFrequencyId;
    }

    public void setMeasurementFrequencyId(int measurementFrequencyId) {
        this.measurementFrequencyId = measurementFrequencyId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
