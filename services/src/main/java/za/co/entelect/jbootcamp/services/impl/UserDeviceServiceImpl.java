package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.persistence.DeviceManufacturerRepository;
import za.co.entelect.jbootcamp.persistence.UserDeviceRepository;
import za.co.entelect.jbootcamp.persistence.UserFitnessProfileRepository;
import za.co.entelect.jbootcamp.persistence.UserProfileRepository;
import za.co.entelect.jbootcamp.services.DeviceService;
import za.co.entelect.jbootcamp.services.UserDeviceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {
    private UserDeviceRepository userDeviceRepository;
    private DeviceService deviceService;
    private UserProfileRepository userProfileRepository;
    private UserFitnessProfileRepository userFitnessProfileRepository;


    @Autowired
    public UserDeviceServiceImpl(UserDeviceRepository userDeviceRepository,
                                 DeviceService deviceService,
                                 UserProfileRepository userProfileRepository,
                                 UserFitnessProfileRepository userFitnessProfileRepository) {
        this.deviceService = deviceService;
        this.userProfileRepository = userProfileRepository;
        this.userFitnessProfileRepository = userFitnessProfileRepository;
        this.userDeviceRepository = userDeviceRepository;
    }

    @Override
    public UserDevice findById(int id) {
        return userDeviceRepository.findOne(id);
    }

    @Override
    public List<UserDevice> findAll() {
        return userDeviceRepository.findAll();
    }

    @Override
    public Page<UserDevice> findAll(Pageable pageable) {
        return userDeviceRepository.findAll(pageable);
    }

    @Override
    public List<UserDevice> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<UserDevice> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return userDeviceRepository.count();
    }

    @Override
    @Transactional
    public UserDevice create(UserDevice object) {
        return userDeviceRepository.save(object);
    }

    @Override
    @Transactional
    public UserDevice update(UserDevice object) {
        return userDeviceRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public Page<UserDevice> findByUserId(int userId, Pageable pageable) {
        return userDeviceRepository.findByUserFitnessProfileId(userId, pageable);
    }

    @Override
    @Transactional
    public UserDevice addDeviceToUser(String username, int deviceId, String name, String serialNumber, boolean isActive) {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        UserFitnessProfile userFitnessProfile = userFitnessProfileRepository.findOne(userProfile.getId());
        Device device = deviceService.findById(deviceId);
        UserDevice userDevice = new UserDevice(device, name, serialNumber, isActive);
        userDevice.setUserFitnessProfile(userFitnessProfile);
        return userDeviceRepository.save(userDevice);
    }
}
