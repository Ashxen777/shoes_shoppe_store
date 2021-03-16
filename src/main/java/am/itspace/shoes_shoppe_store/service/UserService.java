package am.itspace.shoes_shoppe_store.service;

import am.itspace.shoes_shoppe_store.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> getAll();

    User saveUser(User user);

    Optional<User> findByEmail(String email);

}
