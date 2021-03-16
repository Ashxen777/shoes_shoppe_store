package am.itspace.shoes_shoppe_store.repository;


import am.itspace.shoes_shoppe_store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
   List<Address> findAddressByUserId(int id);
}
