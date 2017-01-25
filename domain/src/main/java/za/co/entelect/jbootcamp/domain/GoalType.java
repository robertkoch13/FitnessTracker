package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="goal_type")
public class GoalType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "GoalType{" +
                "goalType='" + goalType + '\'' +
                '}';
    }
}
