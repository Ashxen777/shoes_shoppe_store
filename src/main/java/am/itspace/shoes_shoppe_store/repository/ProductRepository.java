package am.itspace.shoes_shoppe_store.repository;




import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

 List<Product> findTop5ByCategory(Category category);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR CONCAT( p.category, '') LIKE %?1%"
            +" OR p.color LIKE %?1%"
            +" OR p.desc LIKE %?1%"
            +" OR CONCAT( p.type,'') LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
    List<Product> search(String keyword);

    @Query(value = "SELECT * FROM Product  WHERE color=:color",nativeQuery = true)
    List<Product> findByColor( String color);

    List<Product> findByCategory(Category category);

    List<Product> findByType(Type type);

   @Query(value = "SELECT * FROM Product  WHERE color=:color AND type =:type ",nativeQuery = true)
   List<Product> findByColorAndType( String color,String type);

   @Query(value = "SELECT * FROM Product  WHERE price>=:min AND price <=:max ",nativeQuery = true)
   List<Product> findByPrice( int min,int max);

}