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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String country;


    private String region;

    private String city;

    private String street;

    private String flat;

    private String phone;
    @ManyToOne
    private User user;


}
