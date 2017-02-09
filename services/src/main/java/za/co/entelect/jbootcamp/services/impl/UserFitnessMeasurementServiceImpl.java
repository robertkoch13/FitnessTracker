package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.DTO.UserFitnessMeasurementCalculationsDTO;
import za.co.entelect.jbootcamp.domain.MeasurementType;
import za.co.entelect.jbootcamp.domain.UserFitnessMeasurement;
import za.co.entelect.jbootcamp.domain.UserGoal;
import za.co.entelect.jbootcamp.persistence.MeasurementTypeRepository;
import za.co.entelect.jbootcamp.persistence.UserFitnessMeasurementCalculationsDAO;
import za.co.entelect.jbootcamp.persistence.UserFitnessMeasurementRepository;
import za.co.entelect.jbootcamp.persistence.UserGoalRepository;
import za.co.entelect.jbootcamp.persistence.impl.UserFitnessMeasurementCalculationsDAOImpl;
import za.co.entelect.jbootcamp.services.UserFitnessMeasurementService;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementModel;
import za.co.entelect.jbootcamp.services.model.UserFitnessMeasurementsFrequency;

import java.util.*;

@Service
public class UserFitnessMeasurementServiceImpl implements UserFitnessMeasurementService {
    private UserFitnessMeasurementRepository userFitnessMeasurementRepository;
    private MeasurementTypeRepository measurementTypeRepository;
    private UserGoalRepository userGoalRepository;
    private UserFitnessMeasurementCalculationsDAO userFitnessMeasurementCalculationsDAO;

    @Autowired
    public UserFitnessMeasurementServiceImpl(UserFitnessMeasurementRepository userFitnessMeasurementRepository,
                                             MeasurementTypeRepository measurementTypeRepository,
                                             UserGoalRepository userGoalRepository,
                                             UserFitnessMeasurementCalculationsDAO userFitnessMeasurementCalculationsDAO) {
        this.userFitnessMeasurementRepository = userFitnessMeasurementRepository;
        this.userFitnessMeasurementCalculationsDAO = userFitnessMeasurementCalculationsDAO;
        this.measurementTypeRepository = measurementTypeRepository;
        this.userGoalRepository = userGoalRepository;
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

    @Override
    public UserFitnessMeasurementModel getCalculatedMeasurements(int userId, String measurementTypeName, Date fromDate, Date toDate, UserFitnessMeasurementsFrequency userFitnessMeasurementsFrequency) {
        UserFitnessMeasurementModel userFitnessMeasurementModel = new UserFitnessMeasurementModel();

        MeasurementType measurementType = measurementTypeRepository.findByName(measurementTypeName);
        UserGoal userGoal = userGoalRepository.findByUserFitnessProfileIdAndMeasurementTypeId(userId, measurementType.getId());

        userFitnessMeasurementModel.setFromDate(fromDate);
        userFitnessMeasurementModel.setToDate(toDate);
        userFitnessMeasurementModel.setMeasurementType(measurementTypeName);

        if(userGoal != null) {
            userFitnessMeasurementModel.setGoalDate(userGoal.getGoalDate());
            userFitnessMeasurementModel.setGoalValue(userGoal.getGoalValue());
        }

        if(measurementType != null) {
            if(userFitnessMeasurementsFrequency.equals(UserFitnessMeasurementsFrequency.Daily)) {
                userFitnessMeasurementModel.setUserFitnessMeasurementCalculationsDTOList(
                        userFitnessMeasurementCalculationsDAO.getCalculationsGroupedByDay(
                                userId, measurementType.getId(), fromDate, toDate
                        ));
            } else if(userFitnessMeasurementsFrequency.equals(UserFitnessMeasurementsFrequency.Monthly)) {
                userFitnessMeasurementModel.setUserFitnessMeasurementCalculationsDTOList(
                        userFitnessMeasurementCalculationsDAO.getCalculationsGroupedByMonth(
                                userId, measurementType.getId(), fromDate, toDate
                        ));
            }
        }

        return userFitnessMeasurementModel;
    }

    private Date oneMonthsAgo() {
        Date referenceDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(referenceDate);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

}
