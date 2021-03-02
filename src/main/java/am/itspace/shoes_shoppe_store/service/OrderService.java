package am.itspace.shoes_shoppe_store.service;

import am.itspace.shoes_shoppe_store.model.Order;
import am.itspace.shoes_shoppe_store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){
       return orderRepository.save(order);
    }
}
