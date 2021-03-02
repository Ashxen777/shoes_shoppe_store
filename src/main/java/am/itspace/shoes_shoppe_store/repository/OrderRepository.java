package am.itspace.shoes_shoppe_store.repository;



import am.itspace.shoes_shoppe_store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
