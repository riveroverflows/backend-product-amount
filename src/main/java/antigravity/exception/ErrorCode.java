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
    INVALID_PROMOTION_TYPE(HttpStatus.BAD_REQUEST, "Promotion type is invalid"),
    PRICE_OUT_OF_RANGE(HttpStatus.BAD_REQUEST, "Price is out of range"),
    INVALID_PRODUCT_ID(HttpStatus.BAD_REQUEST, "Product ID is invalid"),
    INVALID_COUPON_IDS(HttpStatus.BAD_REQUEST, "Coupon IDs are invalid"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request");

    private final HttpStatus status;
    private final String message;
}
