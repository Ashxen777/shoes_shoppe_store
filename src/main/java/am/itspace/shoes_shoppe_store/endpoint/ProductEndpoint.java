package am.itspace.shoes_shoppe_store.endpoint;


import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Type;
import am.itspace.shoes_shoppe_store.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductEndpoint {


    private final ProductService productService;


    @GetMapping("/product")
    public List<Product> getProduct() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    public void createdProduct(@RequestBody Product product) {
        if (product.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        productService.saveProduct(product);
    }

    @GetMapping("/product/search/{keyword}")
    public List<Product> search(@PathVariable String keyword) {
        if (keyword != null) {
            return productService.search(keyword);

        }
        return productService.getProducts();
    }

    @GetMapping("/product/filterByCategory/{category}")
    public List<Product> filterByCategory(@PathVariable Category category) {
        if (category != null) {

            return productService.findByCategory(category);

        }
        return productService.getProducts();
    }

    @GetMapping("/product/filterByType/{type}")
    public List<Product> filterByType(@PathVariable Type type) {
        if (type != null) {

            return productService.findByType(type);

        }
        return productService.getProducts();
    }

    @GetMapping("/product/filterByColor/{color}")
    public List<Product> filterByColor(@PathVariable String color) {
        if (color != null) {

            return productService.findByColor(color);

        }
        return productService.getProducts();
    }
 @GetMapping("/product/filterByColorAndType/{color}/{type}")
    public List<Product> filterByColorAndType(@PathVariable String color, @PathVariable String type) {
        if (color != null && type!=null) {

            return productService.findByColorAndType(color,type);

        }
        return productService.getProducts();
    }
 @GetMapping("/product/filterByPrice/{min}/{max}")
    public List<Product> filterByColorAndType(@PathVariable int min, @PathVariable int max) {

        return productService.findByPrice(min, max);

    }

    @GetMapping("/product/top/{category}")
    public List<Product> topCategory(@PathVariable Category category) {
        return productService.findTopByCategory(category);
    }
}
