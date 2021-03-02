package am.itspace.shoes_shoppe_store.service;


import am.itspace.shoes_shoppe_store.model.Card;
import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.User;
import am.itspace.shoes_shoppe_store.repository.CardRepository;
import am.itspace.shoes_shoppe_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ProductRepository productRepository;

    public Card updateCard(int productId, int count, User user) {
        Card card = user.getCard();
        List<Product> products = card.getProducts();
        for (int i = 0; i < count; i++) {
            products.add(productRepository.getOne(productId));
        }
        card.setProducts(products);
        card.setUser(user);
        card.setPrice(getCartSum(card));
        return cardRepository.save(card);

    }

    private double getCartSum(Card card) {
        List<Product> products = card.getProducts();
        double sum = 0.0;
        for (Product product : products) {
            sum += Double.sum(product.getPrice(), 0.0);
        }
        return sum;
    }
}
