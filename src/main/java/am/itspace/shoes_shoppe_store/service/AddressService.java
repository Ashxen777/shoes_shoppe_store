package am.itspace.shoes_shoppe_store.service;


import am.itspace.shoes_shoppe_store.model.Address;
import am.itspace.shoes_shoppe_store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(Address address){
        addressRepository.save(address);
    }
    public List <Address> getAddressById(int id){
        return addressRepository.findAddressByUserId(id);
    }
}
