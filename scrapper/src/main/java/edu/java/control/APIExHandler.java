package edu.java.control;

import edu.java.control.commandDto.APIEresponse;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class APIExHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIEresponse> handleValidationException(MethodArgumentNotValidException exception) {
        APIEresponse response = createErrorResponse(exception, "400", "Validation error");
        return ResponseEntity.badRequest().body(response);
    }

    private APIEresponse createErrorResponse(Exception exception, String code, String description) {
        // была проблема с конструктором по всем аргументам. сделал обычнй
        return new APIEresponse(
            description,
            code,
            exception.getClass().getSimpleName(),
            exception.getMessage(),
            Stream.of(exception.getStackTrace()).map(StackTraceElement::toString).toList()
        );
    }
}
