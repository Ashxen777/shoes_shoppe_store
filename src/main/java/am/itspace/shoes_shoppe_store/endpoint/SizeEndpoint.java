package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Size;
import am.itspace.shoes_shoppe_store.service.serviceImpl.SizeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeEndpoint {

    private final SizeServiceImpl sizeService;

    @PostMapping("/")
    public void saveSize(@RequestBody Size size) {
        sizeService.saveSize(size);
    }

}
