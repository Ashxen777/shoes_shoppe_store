package am.itspace.shoes_shoppe_store.model;

import am.itspace.shoes_shoppe_store.model.enums.Gender;
import am.itspace.shoes_shoppe_store.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private boolean active;

    private String email;


    private String password;

    @Transient
    private String rePassword;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    @JsonIgnore
    private Card card;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    @JsonIgnore
    private Order order;

    @Column(name = "picture_url")
    private String profilePic;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

    private String token;

    public void setCard(Card card) {
        card.setUser(this);
        this.card = card;

    }
    public void setOrder(Order order) {
        order.setUser(this);
        this.order = order;

    }

}
