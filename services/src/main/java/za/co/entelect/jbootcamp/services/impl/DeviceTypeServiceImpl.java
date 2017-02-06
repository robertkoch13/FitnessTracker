package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.DeviceType;
import za.co.entelect.jbootcamp.persistence.DeviceTypeRepository;
import za.co.entelect.jbootcamp.services.DeviceTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    public DeviceTypeServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public DeviceType findById(int id) {
        return deviceTypeRepository.findOne(id);
    }

    @Override
    public List<DeviceType> findAll() {
        return deviceTypeRepository.findAll();
    }

    @Override
    public Page<DeviceType> findAll(Pageable pageable) {
        return deviceTypeRepository.findAll(pageable);
    }

    @Override
    public List<DeviceType> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<DeviceType> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return deviceTypeRepository.count();
    }

    @Override
    @Transactional
    public DeviceType create(DeviceType object) {
        return deviceTypeRepository.save(object);
    }

    @Override
    @Transactional
    public DeviceType update(DeviceType object) {
        return deviceTypeRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }
}
