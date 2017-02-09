package za.co.entelect.jbootcamp.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import za.co.entelect.jbootcamp.DTO.UserFitnessMeasurementCalculationsDTO;

public class UserFitnessMeasurementCalculationsRowMapper implements RowMapper<UserFitnessMeasurementCalculationsDTO> {
    public UserFitnessMeasurementCalculationsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserFitnessMeasurementCalculationsDTO userFitnessMeasurementCalculationsDTO = new UserFitnessMeasurementCalculationsDTO();
        userFitnessMeasurementCalculationsDTO.setDateValue(rs.getString("datevalue"));
        userFitnessMeasurementCalculationsDTO.setMaxValue(rs.getDouble("highest"));
        userFitnessMeasurementCalculationsDTO.setMinValue(rs.getDouble("lowest"));
        userFitnessMeasurementCalculationsDTO.setAverageValue(rs.getDouble("average"));
        return userFitnessMeasurementCalculationsDTO;
    }

}
