package za.co.entelect.jbootcamp.persistence;

import za.co.entelect.jbootcamp.DTO.UserFitnessMeasurementCalculationsDTO;

import java.util.Date;
import java.util.List;

public interface UserFitnessMeasurementCalculationsDAO {
    List<UserFitnessMeasurementCalculationsDTO> getCalculationsGroupedByDay(int userid, int measurementTypeId, Date fromDate, Date toDate);
    List<UserFitnessMeasurementCalculationsDTO> getCalculationsGroupedByMonth(int userid, int measurementTypeId, Date fromDate, Date toDate);
}
