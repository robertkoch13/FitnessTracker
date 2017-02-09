package za.co.entelect.jbootcamp.services.model;

import za.co.entelect.jbootcamp.DTO.UserFitnessMeasurementCalculationsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFitnessMeasurementModel {
    private Date fromDate;
    private Date toDate;
    List<UserFitnessMeasurementCalculationsDTO> userFitnessMeasurementCalculationsDTOList = new ArrayList<>();
    Object[][] chartData = new Object[0][0];
    private double goalValue;
    private Date goalDate;
    private String measurementType;

    public UserFitnessMeasurementModel() {
    }

    public UserFitnessMeasurementModel(Date fromDate, Date toDate, List<UserFitnessMeasurementCalculationsDTO> userFitnessMeasurementCalculationsDTOList, double goalValue, Date goalDate, String measurementType) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.userFitnessMeasurementCalculationsDTOList = userFitnessMeasurementCalculationsDTOList;
        this.goalValue = goalValue;
        this.goalDate = goalDate;
        this.measurementType = measurementType;
        CalcChartData();
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<UserFitnessMeasurementCalculationsDTO> getUserFitnessMeasurementCalculationsDTOList() {
        return userFitnessMeasurementCalculationsDTOList;
    }

    public void setUserFitnessMeasurementCalculationsDTOList(List<UserFitnessMeasurementCalculationsDTO> userFitnessMeasurementCalculationsDTOList) {
        this.userFitnessMeasurementCalculationsDTOList = userFitnessMeasurementCalculationsDTOList;
        CalcChartData();
    }

    public double getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(double goalValue) {
        this.goalValue = goalValue;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public Object[][] getChartData() {
        return chartData;
    }

    public void setChartData(Object[][] chartData) {
        this.chartData = chartData;
    }

    private void CalcChartData() {
        chartData = new Object[userFitnessMeasurementCalculationsDTOList.size()+1][5];

        chartData[0][0] = "Period";
        chartData[0][1] = "Minimum";
        chartData[0][2] = "Average";
        chartData[0][3] = "Maximum";
        chartData[0][4] = "Average";

        for(int i = 0; i < userFitnessMeasurementCalculationsDTOList.size(); i++) {
            chartData[i+1][0] = userFitnessMeasurementCalculationsDTOList.get(i).getDateValue();
            chartData[i+1][1] = userFitnessMeasurementCalculationsDTOList.get(i).getMinValue();
            chartData[i+1][2] = userFitnessMeasurementCalculationsDTOList.get(i).getAverageValue();
            chartData[i+1][3] = userFitnessMeasurementCalculationsDTOList.get(i).getMaxValue();
            chartData[i+1][4] = userFitnessMeasurementCalculationsDTOList.get(i).getAverageValue();
        }
    }

}
