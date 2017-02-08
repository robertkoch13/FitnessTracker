package za.co.entelect.jbootcamp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_goal")
public class UserGoal implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_goal_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goal_type_id", nullable = false)
    private GoalType goalType;

    @Column(name="enabled")
    private boolean isEnabled;

    @Temporal(TemporalType.DATE)
    @Column(name="date_logged")
    private Date dateLogged;

    @Temporal(TemporalType.DATE)
    @Column(name="date_completed")
    private Date dateCompleted;

    @Temporal(TemporalType.DATE)
    @Column(name="goal_date")
    private Date goalDate;

    @Column(name="goal_value")
    private double goalValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "measurement_type_id", nullable = false)
    private MeasurementType measurementType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserFitnessProfile userFitnessProfile;

    public UserGoal() {}

    public UserGoal(GoalType goalType, boolean isEnabled, Date dateLogged, Date goalDate, double goalValue, MeasurementType measurementType) {
        this.goalType = goalType;
        this.isEnabled = isEnabled;
        this.dateLogged = dateLogged;
        this.goalDate = goalDate;
        this.goalValue = goalValue;
        this.measurementType = measurementType;
    }

    public UserGoal(int id, GoalType goalType, boolean isEnabled, Date dateLogged, Date dateCompleted, Date goalDate, double goalValue, MeasurementType measurementType) {
        this.id = id;
        this.goalType = goalType;
        this.isEnabled = isEnabled;
        this.dateLogged = dateLogged;
        this.dateCompleted = dateCompleted;
        this.goalDate = goalDate;
        this.goalValue = goalValue;
        this.measurementType = measurementType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    public double getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(double goalValue) {
        this.goalValue = goalValue;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public UserFitnessProfile getUserFitnessProfile() {
        return userFitnessProfile;
    }

    public void setUserFitnessProfile(UserFitnessProfile userFitnessProfile) {
        this.userFitnessProfile = userFitnessProfile;
    }

    @Override
    public String toString() {
        return "UserGoal{" +
                "goalType=" + goalType +
                ", goalDate=" + goalDate +
                ", goalValue=" + goalValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserGoal userGoal = (UserGoal) o;

        return new EqualsBuilder()
                .append(isEnabled, userGoal.isEnabled)
                .append(goalValue, userGoal.goalValue)
                .append(goalType, userGoal.goalType)
                .append(dateLogged, userGoal.dateLogged)
                .append(dateCompleted, userGoal.dateCompleted)
                .append(goalDate, userGoal.goalDate)
                .append(measurementType, userGoal.measurementType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(goalType)
                .append(isEnabled)
                .append(dateLogged)
                .append(dateCompleted)
                .append(goalDate)
                .append(goalValue)
                .append(measurementType)
                .toHashCode();
    }
}
