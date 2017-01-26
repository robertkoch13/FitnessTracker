package za.co.entelect.jbootcamp.domain;

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

    public MeasurementFrequency(int id, String frequency) {
        this.id = id;
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
        return "MeasurementFrequency{" +
                "frequency='" + frequency + '\'' +
                '}';
    }
}
