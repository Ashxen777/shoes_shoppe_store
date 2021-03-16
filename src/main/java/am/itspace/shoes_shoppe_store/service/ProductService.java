package am.itspace.shoes_shoppe_store.service;

import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Type;

import java.util.List;


public interface ProductService {

    void saveProduct(Product product);

    List<Product> getProducts();

    List<Product> search(String keyword);

    List<Product> findByCategory(Category category);

    List<Product> findByType(Type type);

    List<Product> findByColor(String color);

    List<Product> findTopByCategory(Category category);

    List<Product> findByColorAndType(String color, String type);

    List<Product> findByPrice(int min, int max);

    Product findById(int id);
    Product updateSize(int sizeId, int productId);
}
