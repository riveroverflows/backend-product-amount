package antigravity.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),
    PROMOTION_NOT_FOUND(HttpStatus.NOT_FOUND, "Promotion not found"),
    PROMOTION_PRODUCTS_NOT_FOUND(HttpStatus.NOT_FOUND, "Promotion-Products mapping information not found"),
    PRICE_OUT_OF_RANGE(HttpStatus.BAD_REQUEST, "Price is out of range");

    private final HttpStatus status;
    private final String message;
}
