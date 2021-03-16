package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Order;
import am.itspace.shoes_shoppe_store.security.CurrentUser;
import am.itspace.shoes_shoppe_store.service.serviceImpl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderEndpoint {

    private final OrderServiceImpl orderService;


    @PostMapping("/{product_id}/{count}")
    public Order saveOrder(@PathVariable("product_id")int productId, @PathVariable("count")int count, @AuthenticationPrincipal CurrentUser user) {
         return orderService.updateOrder(productId,count,user.getUser());

    }


}
