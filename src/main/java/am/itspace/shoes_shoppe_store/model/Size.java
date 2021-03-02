package am.itspace.shoes_shoppe_store.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int size;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
