package antigravity.model.request;

import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@Getter
public class ProductInfoRequest {
    private int productId;
    private int[] couponIds;

    @Builder
    public ProductInfoRequest(int productId, int[] couponIds) {
        validate(productId, couponIds);
        this.productId = productId;
        this.couponIds = couponIds;
    }

    public void validate() {
        validate(getProductId(), getCouponIds());
    }

    public boolean isCouponIdsLengthEqual(int length) {
        return couponIds.length == length;
    }

    private static void validate(int productId, int[] couponIds) {
        if (productId <= 0) {
            throw new AntigravityApplicationException(ErrorCode.INVALID_PRODUCT_ID, "product id: " + productId);
        }
        if (couponIds == null || couponIds.length == 0) {
            throw new AntigravityApplicationException(ErrorCode.INVALID_COUPON_IDS, "coupon ids are empty");
        }
        if (Arrays.stream(couponIds).anyMatch(id -> id <= 0)) {
            throw new AntigravityApplicationException(ErrorCode.INVALID_COUPON_IDS, "coupon ids: " + Arrays.toString(couponIds));
        }
    }
}
