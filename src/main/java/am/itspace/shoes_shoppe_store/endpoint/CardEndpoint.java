package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.model.Card;
import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.security.CurrentUser;
import am.itspace.shoes_shoppe_store.service.CardService;
import am.itspace.shoes_shoppe_store.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CardEndpoint {

    private final CardService cardService;
    private final ProductService productService;


    @PostMapping("/card/{product_id}/{count}")
    public Card saveCard(@PathVariable("product_id")int productId, @PathVariable("count")int count, @AuthenticationPrincipal CurrentUser user) {
         return cardService.updateCard(productId,count,user.getUser());
    }


}
