package am.itspace.shoes_shoppe_store.service.serviceImpl;

import am.itspace.shoes_shoppe_store.model.Order;
import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.User;
import am.itspace.shoes_shoppe_store.repository.OrderRepository;
import am.itspace.shoes_shoppe_store.repository.ProductRepository;
import am.itspace.shoes_shoppe_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;


    public Order updateOrder(int productId, int count, User user) {
        Order order = user.getOrder();
        List<Product> products = order.getProducts();
        for (int i = 0; i < count; i++) {
            products.add(productRepository.getOne(productId));
        }
        order.setProducts(products);
        order.setUser(user);

        return orderRepository.save(order);


    }
}
