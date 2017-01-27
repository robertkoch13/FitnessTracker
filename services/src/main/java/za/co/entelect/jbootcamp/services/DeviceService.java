package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.*;
import java.util.List;

public interface DeviceService {
    Device findDeviceById(int id);
    List<Device> findDeviceAll();
    Page<Device> findDeviceAll(Pageable pageable);
    List<Device> findDeviceByProperty(String property, String searchCriteria);
    Page<Device> findDeviceByProperty(String property, String searchCriteria, Pageable pageable);
    long countDevice();
    Device createDevice(Device object);
    Device updateDevice(Device object);

    DeviceType findDeviceTypeById(int id);
    List<DeviceType> findDeviceTypeAll();
    Page<DeviceType> findDeviceTypeAll(Pageable pageable);
    List<DeviceType> findDeviceTypeByProperty(String property, String searchCriteria);
    Page<DeviceType> findDeviceTypeByProperty(String property, String searchCriteria, Pageable pageable);
    long countDeviceType();
    DeviceType createDeviceType(DeviceType object);
    DeviceType updateDeviceType(DeviceType object);

    DeviceManufacturer findDeviceManufacturerById(int id);
    List<DeviceManufacturer> findDeviceManufacturerAll();
    Page<DeviceManufacturer> findDeviceManufacturerAll(Pageable pageable);
    List<DeviceManufacturer> findDeviceManufacturerByProperty(String property, String searchCriteria);
    Page<DeviceManufacturer> findDeviceManufacturerByProperty(String property, String searchCriteria, Pageable pageable);
    long countDeviceManufacturer();
    DeviceManufacturer createDeviceManufacturer(DeviceManufacturer object);
    DeviceManufacturer updateDeviceManufacturer(DeviceManufacturer object);

    UnitOfMeasurement findUnitOfMeasurementById(int id);
    List<UnitOfMeasurement> findUnitOfMeasurementAll();
    Page<UnitOfMeasurement> findUnitOfMeasurementAll(Pageable pageable);
    List<UnitOfMeasurement> findUnitOfMeasurementByProperty(String property, String searchCriteria);
    Page<UnitOfMeasurement> findUnitOfMeasurementByProperty(String property, String searchCriteria, Pageable pageable);
    long countUnitOfMeasurement();
    UnitOfMeasurement createUnitOfMeasurement(UnitOfMeasurement object);
    UnitOfMeasurement updateUnitOfMeasurement(UnitOfMeasurement object);

    MeasurementFrequency findMeasurementFrequencyById(int id);
    List<MeasurementFrequency> findMeasurementFrequencyAll();
    Page<MeasurementFrequency> findMeasurementFrequencyAll(Pageable pageable);
    List<MeasurementFrequency> findMeasurementFrequencyByProperty(String property, String searchCriteria);
    Page<MeasurementFrequency> findMeasurementFrequencyByProperty(String property, String searchCriteria, Pageable pageable);
    long countMeasurementFrequency();
    MeasurementFrequency createMeasurementFrequency(MeasurementFrequency object);
    MeasurementFrequency updateMeasurementFrequency(MeasurementFrequency object);

    MeasurementType findMeasurementTypeById(int id);
    List<MeasurementType> findMeasurementTypeAll();
    Page<MeasurementType> findMeasurementTypeAll(Pageable pageable);
    List<MeasurementType> findMeasurementTypeByProperty(String property, String searchCriteria);
    Page<MeasurementType> findMeasurementTypeByProperty(String property, String searchCriteria, Pageable pageable);
    long countMeasurementType();
    MeasurementType createMeasurementType(MeasurementType object);
    MeasurementType updateMeasurementType(MeasurementType object);

}
