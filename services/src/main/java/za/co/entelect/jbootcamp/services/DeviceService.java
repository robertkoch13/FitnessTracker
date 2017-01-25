package za.co.entelect.jbootcamp.services;

import za.co.entelect.jbootcamp.domain.*;

import java.util.ArrayList;

public interface DeviceService {
    DeviceManufacturer addDeviceManufacturer(String manufacturer);
    Device addDevice(String name, DeviceManufacturer manufacturer, DeviceType deviceType, String model, MeasurementType measurementType);
    DeviceType addDeviceType(String type);
    MeasurementType addMeasurementType(String name, double accuracy, MeasurementFrequency measurementFrequency, UnitOfMeasurement unitOfMeasurement);
    MeasurementFrequency addMeasurementFrequency(String frequency);
    UnitOfMeasurement addUnitOfMeasurement(String unitOfMeasurement);

    ArrayList<String> getDevices();
}
