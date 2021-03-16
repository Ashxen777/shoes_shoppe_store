package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Address;
import am.itspace.shoes_shoppe_store.security.CurrentUser;
import am.itspace.shoes_shoppe_store.service.serviceImpl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressEndpoint {

    private final AddressServiceImpl addressServiceImpl;


    @PostMapping("/")
    public void saveAddress(@RequestBody Address address, @AuthenticationPrincipal CurrentUser user) {
        if (address.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        address.setUser(user.getUser());
        addressServiceImpl.saveAddress(address);
    }
    @GetMapping("/")
    public List<Address> getAddress(@AuthenticationPrincipal CurrentUser user){

        return addressServiceImpl.getAddressById( user.getUser().getId());
    }

}
