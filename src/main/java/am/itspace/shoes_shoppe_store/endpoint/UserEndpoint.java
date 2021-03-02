package am.itspace.shoes_shoppe_store.endpoint;

import am.itspace.shoes_shoppe_store.dto.AuthRequest;
import am.itspace.shoes_shoppe_store.dto.AuthResponse;
import am.itspace.shoes_shoppe_store.exeption.DuplicateEntityExeption;
import am.itspace.shoes_shoppe_store.model.Card;
import am.itspace.shoes_shoppe_store.model.Order;
import am.itspace.shoes_shoppe_store.model.Product;
import am.itspace.shoes_shoppe_store.model.User;
import am.itspace.shoes_shoppe_store.repository.CardRepository;
import am.itspace.shoes_shoppe_store.service.CardService;
import am.itspace.shoes_shoppe_store.service.EmailService;
import am.itspace.shoes_shoppe_store.service.OrderService;
import am.itspace.shoes_shoppe_store.service.UserService;
import am.itspace.shoes_shoppe_store.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil tokenUtil;
    private final EmailService emailService;
    private final CardService cardService;
    private final OrderService orderService;

    @PostMapping("/user/auth")
    public ResponseEntity auth(@RequestBody AuthRequest authRequest) {
        Optional<User> byEmail = userService.findByEmail(authRequest.getEmail());
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                String token = tokenUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(AuthResponse.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .token(token)
                        .build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

    @PostMapping("/user")
    public void creatUser(@RequestBody User user) {

        if (!user.getPassword().equals(user.getRePassword())) {
            throw new RuntimeException("Password is wrong");
        } else {
            Optional<User> byEmail = userService.findByEmail(user.getEmail());
            if (!byEmail.isPresent()) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setCard(new Card());
                user.setOrder(new Order());
                user.setActive(false);
                user.setToken(UUID.randomUUID().toString());
                userService.saveUser(user);
                String link = "http://localhost:8080/activate/{email}" + user.getEmail() + "&" +
                        "/{token}" + user.getToken();
                emailService.send(user.getEmail(), "Welcome ", "Dear  " + user.getName() + "  you have successfully registered.Please activate your account by clicking on link  " + link);
            } else {
                throw new DuplicateEntityExeption("Email already exist");

            }
        }
    }

    @GetMapping("/activate/{email}/{token}")
    public void userActivate(@PathVariable String email, @PathVariable String token) {
        Optional<User> byEmail = userService.findByEmail(email);
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (user.getToken().equals(token)) {
                user.setActive(true);
                user.setToken("");
                userService.saveUser(user);
            }
        }

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }


}
