package am.itspace.shoes_shoppe_store.repository;


import am.itspace.shoes_shoppe_store.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Integer> {
}
