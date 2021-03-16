package am.itspace.shoes_shoppe_store.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int size;
    private int count;
    @ManyToMany(mappedBy = "sizes", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> product;

}
