package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.UserDevice;

import java.util.List;

public interface UserDeviceService {
    UserDevice findById(int id);
    List<UserDevice> findAll();
    Page<UserDevice> findAll(Pageable pageable);
    List<UserDevice> findByProperty(String property, String searchCriteria);
    Page<UserDevice> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    UserDevice create(UserDevice object);
    UserDevice update(UserDevice object);
    List<String> getSearchProperties();
    Page<UserDevice> findByUserId(int userId, Pageable pageable);
    UserDevice addDeviceToUser(String username, int deviceId, String name, String serialNumber, boolean isActive);

}
