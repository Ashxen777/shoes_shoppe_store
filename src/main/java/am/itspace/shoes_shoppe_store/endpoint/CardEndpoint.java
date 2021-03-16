package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Card;
import am.itspace.shoes_shoppe_store.security.CurrentUser;
import am.itspace.shoes_shoppe_store.service.serviceImpl.CardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardEndpoint {

    private final CardServiceImpl cardServiceImpl;



    @PostMapping("/{product_id}/{count}")
    public Card saveCard(@PathVariable("product_id")int productId, @PathVariable("count")int count, @AuthenticationPrincipal CurrentUser user) {
         return cardServiceImpl.updateCard(productId,count,user.getUser());
    }


}
