package com.medicalstore.medicalstore.cmd.account.handler;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.account.dmain.hibernate.AddressData;
import com.medicalstore.medicalstore.codegen.types.Address;
import com.medicalstore.medicalstore.codegen.types.AddressInput;
import com.medicalstore.medicalstore.codegen.types.Location;
import com.medicalstore.medicalstore.codegen.types.LocationInput;

@Component
public class AddressConvertors {

    public Address toAddress(AddressData address) {
        Address address1 = new Address();
        address1.setAddressId(address.getAddressId());
        address1.setDoor(address.getDoor());
        address1.setBuilding(address.getBuilding());
        address1.setLandmark(address.getLandmark());
        address1.setStreet(address.getStreet());
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        address1.setCountry(address.getCountry());
        address1.setPinCode(address.getPinCode());
        address1.setName(address.getName());
        address1.setLocation(toLocationInput(address.getLatLong()));
        return address1;
    }

    public AddressData toAddressData(AddressInput address) {
        AddressData addressData = new AddressData();
        addressData.setAddressId(address.getAddressId());
        addressData.setDoor(address.getDoor());
        addressData.setBuilding(address.getBuilding());
        addressData.setLandmark(address.getLandmark());
        addressData.setStreet(address.getStreet());
        addressData.setCity(address.getCity());
        addressData.setState(address.getState());
        addressData.setCountry(address.getCountry());
        addressData.setPinCode(address.getPinCode());
        addressData.setName(address.getName());
        addressData.setLatLong(toLatLog(address.getLocation()));

        return addressData;
    }

    public String toLatLog(LocationInput location) {
        return location.getLatitude() + "," + location.getLongitude();
    }

    public Location toLocationInput(String latLong) {
        Location location = new Location();
        String[] latLongArray = latLong.split(",");
        location.setLatitude(latLongArray[0]);
        location.setLongitude(latLongArray[1]);
        return location;
    }
}
