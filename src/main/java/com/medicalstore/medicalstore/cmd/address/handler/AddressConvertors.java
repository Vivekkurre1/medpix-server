package com.medicalstore.medicalstore.cmd.address.handler;

import org.springframework.stereotype.Component;

import com.medicalstore.medicalstore.cmd.address.model.domain.hibernate.AddressData;
import com.medicalstore.medicalstore.codegen.types.Address;

@Component
public class AddressConvertors {

    public Address toAddress(AddressData address) {
        Address address1 = new Address();
        address1.setId(address.getId());
        address1.setStreet(address.getStreet());
        address1.setCity(address.getCity());
        address1.setCountry(address.getCountry());
        return address1;
    }

    public AddressData toAddressData(Address address) {
        AddressData addressData = new AddressData();
        addressData.setId(address.getId());
        addressData.setStreet(address.getStreet());
        addressData.setCity(address.getCity());
        addressData.setCountry(address.getCountry());
        return addressData;
    }
}
