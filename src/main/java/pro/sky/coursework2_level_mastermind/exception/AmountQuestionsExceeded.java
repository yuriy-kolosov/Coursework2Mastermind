package pro.sky.coursework2_level_mastermind.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountQuestionsExceeded extends RuntimeException {
    public AmountQuestionsExceeded(String message) {
        super(message);
    }
}
