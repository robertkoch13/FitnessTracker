package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.DeviceManufacturer;
import za.co.entelect.jbootcamp.persistence.DeviceManufacturerRepository;
import za.co.entelect.jbootcamp.services.DeviceManufacturerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceManufacturerServiceImpl implements DeviceManufacturerService {
    private DeviceManufacturerRepository deviceManufacturerRepository;

    @Autowired
    public DeviceManufacturerServiceImpl(DeviceManufacturerRepository deviceManufacturerRepository) {
        this.deviceManufacturerRepository = deviceManufacturerRepository;
    }

    @Override
    public DeviceManufacturer findById(int id) {
        return deviceManufacturerRepository.findOne(id);
    }

    @Override
    public List<DeviceManufacturer> findAll() {
        return deviceManufacturerRepository.findAll();
    }

    @Override
    public Page<DeviceManufacturer> findAll(Pageable pageable) {
        return deviceManufacturerRepository.findAll(pageable);
    }

    @Override
    public List<DeviceManufacturer> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<DeviceManufacturer> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return deviceManufacturerRepository.count();
    }

    @Override
    @Transactional
    public DeviceManufacturer create(DeviceManufacturer object) {
        return deviceManufacturerRepository.save(object);
    }

    @Override
    @Transactional
    public DeviceManufacturer update(DeviceManufacturer object) {
        return deviceManufacturerRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

}
