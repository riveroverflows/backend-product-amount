package antigravity.domain.entity;

import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Product {
    private int id;
    private String name;
    private int price;

    public void validatePrice() {
        if (price < 10_000 || price > 10_000_000) {
            throw new AntigravityApplicationException(ErrorCode.PRICE_OUT_OF_RANGE, "Price must be between 10,000 and 10,000,000.");
        }
    }
}
