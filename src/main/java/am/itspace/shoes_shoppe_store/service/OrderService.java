package am.itspace.shoes_shoppe_store.service;

import am.itspace.shoes_shoppe_store.model.Order;
import am.itspace.shoes_shoppe_store.model.User;


public interface OrderService {

    Order updateOrder(int productId,int count, User user);


}
