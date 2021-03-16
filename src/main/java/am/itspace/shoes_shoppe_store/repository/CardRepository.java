package am.itspace.shoes_shoppe_store.repository;


import am.itspace.shoes_shoppe_store.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
