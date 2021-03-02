package am.itspace.shoes_shoppe_store.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateEntityExeption extends RuntimeException{
    public DuplicateEntityExeption() {
    }

    public DuplicateEntityExeption(String message) {
        super(message);
    }
}
