package za.co.entelect.jbootcamp.FitnessTracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goal_type")
public class GoalType implements java.io.Serializable {

    @Id
    @Column(name="goal_type_id")
    private int goalTypeId;

    @Column(name="goal_type")
    private String goalType;

    public GoalType() {}

    public GoalType(int goalTypeId, String goalType) {
        this.goalTypeId = goalTypeId;
        this.goalType = goalType;
    }

    public int getGoalTypeId() {
        return goalTypeId;
    }

    public void setGoalTypeId(int goalTypeId) {
        this.goalTypeId = goalTypeId;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }
}
