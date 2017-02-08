package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.UserFitnessMeasurement;

import java.util.Date;
import java.util.List;

public interface UserFitnessMeasurementRepository extends JpaRepository<UserFitnessMeasurement, Integer> {
    List<UserFitnessMeasurement> findByUserDeviceNameAndDateLoggedAfterOrderByDateLoggedDesc(String userDeviceName, Date dateLogged);
}
