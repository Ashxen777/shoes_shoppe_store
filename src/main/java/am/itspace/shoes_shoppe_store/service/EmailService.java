package am.itspace.shoes_shoppe_store.service;

public interface EmailService {
    void send(String to, String subject, String message);

}
