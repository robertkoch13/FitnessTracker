package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.Device;
import za.co.entelect.jbootcamp.domain.UserFitnessMeasurement;
import za.co.entelect.jbootcamp.persistence.UserFitnessMeasurementRepository;
import za.co.entelect.jbootcamp.services.UserFitnessMeasurementService;

import java.util.*;

@Service
public class UserFitnessMeasurementServiceImpl implements UserFitnessMeasurementService {
    private UserFitnessMeasurementRepository userFitnessMeasurementRepository;

    @Autowired
    public UserFitnessMeasurementServiceImpl(UserFitnessMeasurementRepository userFitnessMeasurementRepository) {
        this.userFitnessMeasurementRepository = userFitnessMeasurementRepository;
    }

    @Override
    public UserFitnessMeasurement findById(int id) {
        return userFitnessMeasurementRepository.findOne(id);
    }

    @Override
    public List<UserFitnessMeasurement> findAll() {
        return userFitnessMeasurementRepository.findAll();
    }

    @Override
    public Page<UserFitnessMeasurement> findAll(Pageable pageable) {
        return userFitnessMeasurementRepository.findAll(pageable);
    }

    @Override
    public List<UserFitnessMeasurement> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<UserFitnessMeasurement> findByProperty(String property, String searchCriteria, Pageable pageable) {
            return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return userFitnessMeasurementRepository.count();
    }

    @Override
    @Transactional
    public UserFitnessMeasurement create(UserFitnessMeasurement object) {
        return userFitnessMeasurementRepository.save(object);
    }

    @Override
    @Transactional
    public UserFitnessMeasurement update(UserFitnessMeasurement object) {
        return userFitnessMeasurementRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public List<UserFitnessMeasurement> findDevicesByUserDeviceLastMonth(String userDeviceName) {
        return userFitnessMeasurementRepository.findByUserDeviceNameAndDateLoggedAfterOrderByDateLoggedDesc(userDeviceName, oneMonthsAgo());
    }

    private Date oneMonthsAgo() {
        Date referenceDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(referenceDate);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

}
