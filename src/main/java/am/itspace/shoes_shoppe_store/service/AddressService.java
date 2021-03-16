package am.itspace.shoes_shoppe_store.service;

import am.itspace.shoes_shoppe_store.model.Address;

import java.util.List;


public interface AddressService {
    List<Address> getAddressById(int id);

    void saveAddress(Address address);


}
