package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.persistence.*;
import za.co.entelect.jbootcamp.services.DeviceService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceManufacturerRepository deviceManufacturerRepository;
    private DeviceTypeRepository deviceTypeRepository;
    private DeviceRepository deviceRepository;
    private UnitOfMeasurementRepository unitOfMeasurementRepository;
    private MeasurementFrequencyRepository measurementFrequencyRepository;
    private MeasurementTypeRepository measurementTypeRepository;

    @Autowired
    public DeviceServiceImpl(DeviceManufacturerRepository deviceManufacturerRepository, DeviceTypeRepository deviceTypeRepository, DeviceRepository deviceRepository, UnitOfMeasurementRepository unitOfMeasurementRepository, MeasurementFrequencyRepository measurementFrequencyRepository, MeasurementTypeRepository measurementTypeRepository) {
        this.deviceManufacturerRepository = deviceManufacturerRepository;
        this.deviceTypeRepository = deviceTypeRepository;
        this.deviceRepository = deviceRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
        this.measurementFrequencyRepository = measurementFrequencyRepository;
        this.measurementTypeRepository = measurementTypeRepository;
    }

    @Override
    public Device findDeviceById(int id) {
        return deviceRepository.findOne(id);
    }

    @Override
    public List<Device> findDeviceAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Page<Device> findDeviceAll(Pageable pageable) {
        return deviceRepository.findAll(pageable);
    }

    @Override
    public List<Device> findDeviceByProperty(String property, String searchCriteria) {
        if(property.toUpperCase().equals("DEVICE NAME")) {
            return deviceRepository.findDeviceByDeviceNameContaining(searchCriteria);
        } else
            return new ArrayList<>();
    }

    @Override
    public Page<Device> findDeviceByProperty(String property, String searchCriteria, Pageable pageable) {
        if(property.toUpperCase().equals("DEVICENAME")) {
            return deviceRepository.findDeviceByDeviceNameContaining(searchCriteria, pageable);
        } else
            return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countDevice() {
        return deviceRepository.count();
    }

    @Override
    public Device createDevice(Device object) {
        return deviceRepository.save(object);
    }

    @Override
    public Device updateDevice(Device object) {
        return deviceRepository.save(object);
    }

    @Override
    public DeviceType findDeviceTypeById(int id) {
        return deviceTypeRepository.findOne(id);
    }

    @Override
    public List<DeviceType> findDeviceTypeAll() {
        return deviceTypeRepository.findAll();
    }

    @Override
    public Page<DeviceType> findDeviceTypeAll(Pageable pageable) {
        return deviceTypeRepository.findAll(pageable);
    }

    @Override
    public List<DeviceType> findDeviceTypeByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<DeviceType> findDeviceTypeByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countDeviceType() {
        return deviceTypeRepository.count();
    }

    @Override
    public DeviceType createDeviceType(DeviceType object) {
        return deviceTypeRepository.save(object);
    }

    @Override
    public DeviceType updateDeviceType(DeviceType object) {
        return deviceTypeRepository.save(object);
    }

    @Override
    public DeviceManufacturer findDeviceManufacturerById(int id) {
        return deviceManufacturerRepository.findOne(id);
    }

    @Override
    public List<DeviceManufacturer> findDeviceManufacturerAll() {
        return deviceManufacturerRepository.findAll();
    }

    @Override
    public Page<DeviceManufacturer> findDeviceManufacturerAll(Pageable pageable) {
        return deviceManufacturerRepository.findAll(pageable);
    }

    @Override
    public List<DeviceManufacturer> findDeviceManufacturerByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<DeviceManufacturer> findDeviceManufacturerByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countDeviceManufacturer() {
        return deviceManufacturerRepository.count();
    }

    @Override
    public DeviceManufacturer createDeviceManufacturer(DeviceManufacturer object) {
        return deviceManufacturerRepository.save(object);
    }

    @Override
    public DeviceManufacturer updateDeviceManufacturer(DeviceManufacturer object) {
        return deviceManufacturerRepository.save(object);
    }

    @Override
    public UnitOfMeasurement findUnitOfMeasurementById(int id) {
        return unitOfMeasurementRepository.findOne(id);
    }

    @Override
    public List<UnitOfMeasurement> findUnitOfMeasurementAll() {
        return unitOfMeasurementRepository.findAll();
    }

    @Override
    public Page<UnitOfMeasurement> findUnitOfMeasurementAll(Pageable pageable) {
        return unitOfMeasurementRepository.findAll(pageable);
    }

    @Override
    public List<UnitOfMeasurement> findUnitOfMeasurementByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<UnitOfMeasurement> findUnitOfMeasurementByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countUnitOfMeasurement() {
        return unitOfMeasurementRepository.count();
    }

    @Override
    public UnitOfMeasurement createUnitOfMeasurement(UnitOfMeasurement object) {
        return unitOfMeasurementRepository.save(object);
    }

    @Override
    public UnitOfMeasurement updateUnitOfMeasurement(UnitOfMeasurement object) {
        return unitOfMeasurementRepository.save(object);
    }

    @Override
    public MeasurementFrequency findMeasurementFrequencyById(int id) {
        return measurementFrequencyRepository.findOne(id);
    }

    @Override
    public List<MeasurementFrequency> findMeasurementFrequencyAll() {
        return measurementFrequencyRepository.findAll();
    }

    @Override
    public Page<MeasurementFrequency> findMeasurementFrequencyAll(Pageable pageable) {
        return measurementFrequencyRepository.findAll(pageable);
    }

    @Override
    public List<MeasurementFrequency> findMeasurementFrequencyByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<MeasurementFrequency> findMeasurementFrequencyByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countMeasurementFrequency() {
        return measurementFrequencyRepository.count();
    }

    @Override
    public MeasurementFrequency createMeasurementFrequency(MeasurementFrequency object) {
        return measurementFrequencyRepository.save(object);
    }

    @Override
    public MeasurementFrequency updateMeasurementFrequency(MeasurementFrequency object) {
        return measurementFrequencyRepository.save(object);
    }

    @Override
    public MeasurementType findMeasurementTypeById(int id) {
        return measurementTypeRepository.findOne(id);
    }

    @Override
    public List<MeasurementType> findMeasurementTypeAll() {
        return measurementTypeRepository.findAll();
    }

    @Override
    public Page<MeasurementType> findMeasurementTypeAll(Pageable pageable) {
        return measurementTypeRepository.findAll(pageable);
    }

    @Override
    public List<MeasurementType> findMeasurementTypeByProperty(String property, String searchCriteria) {
        return new ArrayList<>();
    }

    @Override
    public Page<MeasurementType> findMeasurementTypeByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long countMeasurementType() {
        return measurementTypeRepository.count();
    }

    @Override
    public MeasurementType createMeasurementType(MeasurementType object) {
        return measurementTypeRepository.save(object);
    }

    @Override
    public MeasurementType updateMeasurementType(MeasurementType object) {
        return measurementTypeRepository.save(object);
    }
}
