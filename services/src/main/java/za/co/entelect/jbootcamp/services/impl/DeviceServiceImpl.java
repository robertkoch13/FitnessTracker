package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.persistence.*;
import za.co.entelect.jbootcamp.services.DeviceService;

import java.util.ArrayList;

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
    @Transactional
    public DeviceManufacturer addDeviceManufacturer(String manufacturer) {
        DeviceManufacturer deviceManufacturer = new DeviceManufacturer();
        deviceManufacturer.setName(manufacturer);
        return deviceManufacturerRepository.save(deviceManufacturer);
    }

    @Override
    @Transactional
    public Device addDevice(String name, DeviceManufacturer manufacturer, DeviceType deviceType, String model, MeasurementType measurementType) {
        Device device = new Device();
        device.setDeviceName(name);
        device.setDeviceManufacturer(manufacturer);
        device.setDeviceType(deviceType);
        device.setModel(model);
        device.getMeasurementTypes().add(measurementType);
        return deviceRepository.save(device);
    }

    @Override
    @Transactional
    public DeviceType addDeviceType(String type) {
        DeviceType deviceType = new DeviceType();
        deviceType.setName(type);
        deviceTypeRepository.save(deviceType);
        return deviceType;
    }

    @Override
    @Transactional
    public MeasurementType addMeasurementType(String name, double accuracy, MeasurementFrequency measurementFrequency, UnitOfMeasurement unitOfMeasurement) {
        MeasurementType measurementType = new MeasurementType();
        measurementType.setName(name);
        measurementType.setDefaultAccuracy(accuracy);
        measurementType.setMeasurementFrequency(measurementFrequency);
        measurementType.setUnitOfMeasurement(unitOfMeasurement);
        return measurementTypeRepository.save(measurementType);
    }

    @Override
    @Transactional
    public MeasurementFrequency addMeasurementFrequency(String frequency) {
        MeasurementFrequency measurementFrequency = new MeasurementFrequency();
        measurementFrequency.setFrequency(frequency);
        return measurementFrequencyRepository.save(measurementFrequency);
    }

    @Override
    @Transactional
    public UnitOfMeasurement addUnitOfMeasurement(String unitOfMeasurement) {
        UnitOfMeasurement measurementUnit = new UnitOfMeasurement();
        measurementUnit.setUnitOfMeasurement(unitOfMeasurement);
        return unitOfMeasurementRepository.save(measurementUnit);
    }

    @Override
    public Device searchForDeviceByDeviceName(String deviceName) {
        return deviceRepository.findDeviceByDeviceName(deviceName);
    }

    @Override
    public ArrayList<String> getDevices() {
        ArrayList<String> devices = new ArrayList<>();
        for(Device device : deviceRepository.findAll()) {
            devices.add(device.toString());
        }
        return devices;
    }
}
