package za.co.entelect.jbootcamp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name="goal_type")
public class GoalType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goal_type_id")
    private int id;

    @Column(name="goal_type")
    private String goalType;

    public GoalType() {}

    public GoalType(String goalType) {
        this.goalType = goalType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    @Override
    public String toString() {
        return goalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GoalType goalType1 = (GoalType) o;

        return new EqualsBuilder()
                .append(goalType, goalType1.goalType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(goalType)
                .toHashCode();
    }
}
