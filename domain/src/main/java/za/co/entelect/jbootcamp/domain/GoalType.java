package za.co.entelect.jbootcamp.domain;

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

    public GoalType(int id, String goalType) {
        this.id = id;
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
        return "GoalType{" +
                "goalType='" + goalType + '\'' +
                '}';
    }
}
