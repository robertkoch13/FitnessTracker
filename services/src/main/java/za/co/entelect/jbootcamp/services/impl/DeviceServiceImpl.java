package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.persistence.*;
import za.co.entelect.jbootcamp.services.DeviceService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device findById(int id) {
        return deviceRepository.findOne(id);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Page<Device> findAll(Pageable pageable) {
        return deviceRepository.findAll(pageable);
    }

    @Override
    public List<Device> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<Device> findByProperty(String property, String searchCriteria, Pageable pageable) {
        if(property.toUpperCase().equals("DEVICE NAME")) {
            return deviceRepository.findByDeviceNameContaining(searchCriteria, pageable);
        } else if(property.toUpperCase().equals("DEVICE TYPE")) {
            return deviceRepository.findByDeviceTypeName(searchCriteria, pageable);
        } else if(property.toUpperCase().equals("DEVICE MANUFACTURER")) {
            return deviceRepository.findByDeviceManufacturerName(searchCriteria, pageable);
        } else
            return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return deviceRepository.count();
    }

    @Override
    @Transactional
    public Device create(Device object) {
        return deviceRepository.save(object);
    }

    @Override
    @Transactional
    public Device update(Device object) {
        return deviceRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return Arrays.asList("Device Name", "Device Type", "Device Manufacturer");
    }
}
