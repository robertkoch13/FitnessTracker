package za.co.entelect.jbootcamp.cli.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.cli.CommandLineInterface;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.services.DeviceService;

@Component
public class CommandLineInterfaceImpl implements CommandLineInterface {

    private DeviceService deviceService;

    @Autowired
    public CommandLineInterfaceImpl(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public void execute() {
/*        DeviceType deviceType = new DeviceType();
        deviceType
        Device device = new Device();
        device.


        DeviceType deviceType = deviceService.addDeviceType("Wrist");
        DeviceManufacturer deviceManufacturer = deviceService.addDeviceManufacturer("Google");
        MeasurementFrequency measurementFrequency = deviceService.addMeasurementFrequency("Daily");
        UnitOfMeasurement unitOfMeasurement = deviceService.addUnitOfMeasurement("Beats per minute");
        MeasurementType measurementType = deviceService.addMeasurementType("Heart Rate", 0, measurementFrequency, unitOfMeasurement);
        Device device = deviceService.addDevice("Superwow", deviceManufacturer, deviceType, "808P", measurementType);

        System.out.println(deviceService.getDevices());

        Device device2 = deviceService.searchForDeviceByDeviceName("Superwow");
        System.out.println(device2);
*/

    }
}
