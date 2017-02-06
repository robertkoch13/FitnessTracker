package za.co.entelect.jbootcamp.cli.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.jbootcamp.cli.CommandLineInterface;
import za.co.entelect.jbootcamp.domain.*;
import za.co.entelect.jbootcamp.services.DeviceService;
import za.co.entelect.jbootcamp.services.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineInterfaceImpl implements CommandLineInterface {

    private DeviceService deviceService;
    private UserProfileService userProfileService;

    @Autowired
    public CommandLineInterfaceImpl(DeviceService deviceService, UserProfileService userProfileService) {
        this.deviceService = deviceService;
        this.userProfileService = userProfileService;
    }

    @Override
    public void execute() {

/*
        List<Permission> permissions = new ArrayList<>();
        permissions.add(userProfileService.createPermission(new Permission("Manage Device Manufacturers")));
        permissions.add(userProfileService.createPermission(new Permission("Manage Device Types")));
        permissions.add(userProfileService.createPermission(new Permission("Manage Devices")));
        Role role = userProfileService.createRole(new Role("Admin", permissions));

*/

        userProfileService.addPermissionToRole("Admin", "Admin");


/*
        UserProfile userProfile = userProfileService.findUserProfileByUsername("robert.koch@entelect.co.za");
        List<Role> roles = new ArrayList<>();
        roles.add(userProfileService.findRoleByName("Standard"));
        roles.add(userProfileService.findRoleByName("Admin"));
        userProfile.setRoles(roles);
        userProfileService.updateUserProfile(userProfile);
*/

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
