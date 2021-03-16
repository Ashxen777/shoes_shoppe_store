package am.itspace.shoes_shoppe_store.service.serviceImpl;


import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.Size;
import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Type;
import am.itspace.shoes_shoppe_store.repository.ProductRepository;
import am.itspace.shoes_shoppe_store.repository.SizeRepository;
import am.itspace.shoes_shoppe_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
 @Autowired
    private SizeRepository sizeRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> search(String keyword){
        return productRepository.search(keyword);

    }

    public List<Product> findByCategory(Category category){
        return productRepository.findByCategory(category);
    }

    public List<Product> findByType(Type type){
        return productRepository.findByType(type);
    }

    public List<Product> findByColor(String color){
        return productRepository.findByColor(color);
    }

    public   List<Product> findTopByCategory(Category category){
        return productRepository.findTop5ByCategory(category);
    }
    public List<Product> findByColorAndType(String color, String type){
        return productRepository.findByColorAndType(color,type);
    }
    public List<Product> findByPrice(int min, int max){
        return productRepository.findByPrice(min, max);
    }
    public Product findById(int id){
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateSize(int sizeId, int productId) {
        Product product = productRepository.getOne(productId);
        Size size =sizeRepository.getOne(sizeId);
        List<Size> sizes = product.getSizes();

        for (int i = 0; i < size.getCount(); i++) {
            sizes.add(sizeRepository.getOne(size.getId()));
        }
        product.setSizes(sizes);
        return productRepository.save(product);
    }
}
