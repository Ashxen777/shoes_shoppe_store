package am.itspace.shoes_shoppe_store.service.serviceImpl;


import am.itspace.shoes_shoppe_store.model.Size;
import am.itspace.shoes_shoppe_store.repository.SizeRepository;
import am.itspace.shoes_shoppe_store.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;


    public void saveSize(Size size) {
        sizeRepository.save(size);
    }


}
