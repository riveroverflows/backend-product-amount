package antigravity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class AntigravityControllerAdvice {

    @ExceptionHandler(AntigravityApplicationException.class)
    public ResponseEntity<?> applicationHandler(AntigravityApplicationException e) {
        log.error("Error occurs: {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(e.getErrorCode().name());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeHandler(RuntimeException e) {
        log.error("Error occurs: {}", e.toString());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(INTERNAL_SERVER_ERROR.name());
    }
}
