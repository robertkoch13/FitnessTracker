package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.MeasurementType;
import za.co.entelect.jbootcamp.persistence.MeasurementTypeRepository;
import za.co.entelect.jbootcamp.services.MeasurementTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementTypeServiceImpl implements MeasurementTypeService {
    private MeasurementTypeRepository measurementTypeRepository;

    @Autowired
    public MeasurementTypeServiceImpl(MeasurementTypeRepository measurementTypeRepository) {
        this.measurementTypeRepository = measurementTypeRepository;
    }

    @Override
    public MeasurementType findById(int id) {
        return measurementTypeRepository.findOne(id);
    }

    @Override
    public List<MeasurementType> findAll() {
        return measurementTypeRepository.findAll();
    }

    @Override
    public Page<MeasurementType> findAll(Pageable pageable) {
        return measurementTypeRepository.findAll(pageable);
    }

    @Override
    public List<MeasurementType> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<MeasurementType> findByProperty(String property, String searchCriteria, Pageable pageable) {
            return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return measurementTypeRepository.count();
    }

    @Override
    @Transactional
    public MeasurementType create(MeasurementType object) {
        return measurementTypeRepository.save(object);
    }

    @Override
    @Transactional
    public MeasurementType update(MeasurementType object) {
        return measurementTypeRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
