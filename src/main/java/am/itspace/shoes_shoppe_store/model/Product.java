package am.itspace.shoes_shoppe_store.model;

import am.itspace.shoes_shoppe_store.model.enums.Category;
import am.itspace.shoes_shoppe_store.model.enums.Status;
import am.itspace.shoes_shoppe_store.model.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="product")
@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private double price;
    private int count;
    @Column(name = "image_url")
    private String imageUrl;
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private Status status;
    private  String color;
    @Column(name = "description")
    private  String desc;

    @Enumerated(value = EnumType.STRING)
    private Type type;
    private int discount;
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "size_product",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "size_id", referencedColumnName = "id"))
    private List<Size> sizes;
    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Card> card;
    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;
}
