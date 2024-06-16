package antigravity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class AntigravityControllerAdvice {

    @ExceptionHandler(AntigravityApplicationException.class)
    public ResponseEntity<?> applicationHandler(AntigravityApplicationException e) {
        log.error("Error occurs: {}", e.toString());
        Map<String, String> error = new HashMap<>();
        error.put("errorCode", e.getErrorCode().name());
        error.put("errorMessage", e.getErrorCode().getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeHandler(RuntimeException e) {
        log.error("Error occurs: {}", e.toString());
        Map<String, String> error = new HashMap<>();
        error.put("errorCode", HttpStatus.INTERNAL_SERVER_ERROR.name());
        error.put("errorMessage", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(HttpStatus.INTERNAL_SERVER_ERROR.name());
    }
}
