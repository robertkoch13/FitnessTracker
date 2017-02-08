package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.UserDevice;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Integer> {
    Page<UserDevice> findByUserFitnessProfileId(int userId, Pageable pageable);
}
