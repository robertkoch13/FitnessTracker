package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.UserFitnessMeasurement;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementModel;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementsFrequency;

import java.util.Date;
import java.util.List;

public interface UserFitnessMeasurementService {
    UserFitnessMeasurement findById(int id);
    List<UserFitnessMeasurement> findAll();
    Page<UserFitnessMeasurement> findAll(Pageable pageable);
    List<UserFitnessMeasurement> findByProperty(String property, String searchCriteria);
    Page<UserFitnessMeasurement> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    UserFitnessMeasurement create(UserFitnessMeasurement object);
    UserFitnessMeasurement update(UserFitnessMeasurement object);
    List<String> getSearchProperties();
    List<UserFitnessMeasurement> findDevicesByUserDeviceLastMonth(String userDeviceName);
    UserFitnessMeasurementModel getCalculatedMeasurements(int userId,
                                                                String measurementTypeName,
                                                                Date fromDate,
                                                                Date toDate,
                                                                UserFitnessMeasurementsFrequency userFitnessMeasurementsFrequency);
}
