package am.itspace.shoes_shoppe_store.endpoint;


import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Type;
import am.itspace.shoes_shoppe_store.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductEndpoint {


    private final ProductServiceImpl productServiceImpl;


    @GetMapping("/")
    public List<Product> getProduct() {
        return productServiceImpl.getProducts();
    }

    @PostMapping("/")
    public void createdProduct(@RequestBody Product product) {
        if (product.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        productServiceImpl.saveProduct(product);
    }

    @PostMapping("/{product_id}/{size_id}")
    public Product updateSize( @PathVariable("product_id") int productId, @PathVariable("size_id") int sizeId) {
       return productServiceImpl.updateSize(sizeId,productId);
    }


    @GetMapping("/search/{keyword}")
    public List<Product> search(@PathVariable String keyword) {
        if (keyword != null) {
            return productServiceImpl.search(keyword);

        }
        return productServiceImpl.getProducts();
    }

    @GetMapping("/filterByCategory/{category}")
    public List<Product> filterByCategory(@PathVariable Category category) {
        if (category != null) {

            return productServiceImpl.findByCategory(category);

        }
        return productServiceImpl.getProducts();
    }

    @GetMapping("/filterByType/{type}")
    public List<Product> filterByType(@PathVariable Type type) {
        if (type != null) {

            return productServiceImpl.findByType(type);

        }
        return productServiceImpl.getProducts();
    }

    @GetMapping("/filterByColor/{color}")
    public List<Product> filterByColor(@PathVariable String color) {
        if (color != null) {

            return productServiceImpl.findByColor(color);

        }
        return productServiceImpl.getProducts();
    }
 @GetMapping("/filterByColorAndType/{color}/{type}")
    public List<Product> filterByColorAndType(@PathVariable String color, @PathVariable String type) {
        if (color != null && type!=null) {

            return productServiceImpl.findByColorAndType(color,type);

        }
        return productServiceImpl.getProducts();
    }
 @GetMapping("/filterByPrice/{min}/{max}")
    public List<Product> filterByColorAndType(@PathVariable int min, @PathVariable int max) {

        return productServiceImpl.findByPrice(min, max);

    }

    @GetMapping("/top/{category}")
    public List<Product> topCategory(@PathVariable Category category) {
        return productServiceImpl.findTopByCategory(category);
    }
}
