package am.itspace.shoes_shoppe_store.service.serviceImpl;

import am.itspace.shoes_shoppe_store.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private MailSender mailSender;

    @Async
    public void send(String to, String subject, String message) {

        SimpleMailMessage messageSimple = new SimpleMailMessage();
        messageSimple.setTo(to);
        messageSimple.setSubject(subject);
        messageSimple.setText(message);
        mailSender.send(messageSimple);
    }
}
