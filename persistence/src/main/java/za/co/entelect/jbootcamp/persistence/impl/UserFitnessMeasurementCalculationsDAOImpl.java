package za.co.entelect.jbootcamp.persistence.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.entelect.jbootcamp.DTO.UserFitnessMeasurementCalculationsDTO;
import za.co.entelect.jbootcamp.RowMapper.UserFitnessMeasurementCalculationsRowMapper;
import za.co.entelect.jbootcamp.persistence.UserFitnessMeasurementCalculationsDAO;

import java.util.Date;
import java.util.List;

@Repository
public class UserFitnessMeasurementCalculationsDAOImpl implements UserFitnessMeasurementCalculationsDAO {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserFitnessMeasurementCalculationsDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<UserFitnessMeasurementCalculationsDTO> getCalculationsGroupedByDay(int userid, int measurementTypeId, Date fromDate, Date toDate) {
        String sql = "select date(fm.date_time_logged) as datevalue, max(fm.measurement_value) as highest, min(fm.measurement_value) as lowest, round(avg(fm.measurement_value)) as average " +
                "from user_fitness_measurement fm " +
                "where fm.user_id = :userId " +
                "and fm.measurement_type_id = :measurementTypeId " +
                "and fm.date_time_logged >= :fromDate " +
                "and fm.date_time_logged <= :toDate " +
                "group by date(fm.date_time_logged) " +
                "order by date(fm.date_time_logged) asc";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userid);
        params.addValue("measurementTypeId", measurementTypeId);
        params.addValue("fromDate", fromDate);
        params.addValue("toDate", toDate);
        return namedParameterJdbcTemplate.query(sql, params, new UserFitnessMeasurementCalculationsRowMapper());
    }

    @Override
    public List<UserFitnessMeasurementCalculationsDTO> getCalculationsGroupedByMonth(int userid, int measurementTypeId, Date fromDate, Date toDate) {
        String sql = "select concat(year(date_time_logged),'/',month(date_time_logged)) as datevalue, max(fm.measurement_value) as highest, min(fm.measurement_value) as lowest, round(avg(fm.measurement_value)) as average " +
                "from user_fitness_measurement fm " +
                "where fm.user_id = :userId " +
                "and fm.measurement_type_id = :measurementTypeId " +
                "and fm.date_time_logged >= :fromDate " +
                "and fm.date_time_logged <= :toDate " +
                "group by concat(year(date_time_logged),'/',month(date_time_logged)) " +
                "order by concat(year(date_time_logged),'/',month(date_time_logged)) asc";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userid);
        params.addValue("measurementTypeId", measurementTypeId);
        params.addValue("fromDate", fromDate);
        params.addValue("toDate", toDate);
        return namedParameterJdbcTemplate.query(sql, params, new UserFitnessMeasurementCalculationsRowMapper());
    }
}
