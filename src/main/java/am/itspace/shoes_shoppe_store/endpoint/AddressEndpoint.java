package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Address;
import am.itspace.shoes_shoppe_store.security.CurrentUser;
import am.itspace.shoes_shoppe_store.service.AddressService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressEndpoint {

    private final AddressService addressService;


    @PostMapping("/address")
    public void saveAddress(@RequestBody Address address, @AuthenticationPrincipal CurrentUser user) {
        if (address.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        address.setUser(user.getUser());
        addressService.saveAddress(address);
    }
    @GetMapping("/address")
    public List<Address> getAddress(@AuthenticationPrincipal CurrentUser user){

        return addressService.getAddressById( user.getUser().getId());
    }

}
