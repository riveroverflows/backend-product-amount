package antigravity.fixture;

import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import antigravity.model.request.ProductInfoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductInfoRequestFixture {
    public static ProductInfoRequest get(int productId, int... couponIds) {
        return ProductInfoRequest.builder()
                .productId(productId)
                .couponIds(couponIds)
                .build();
    }

    @DisplayName("productId가 음수인 경우")
    @Test
    void product_id_is_negative() {
        int productId = -1;
        int[] couponIds = {1, 2};

        // expect exception
        AntigravityApplicationException e = Assertions.assertThrows(AntigravityApplicationException.class, () -> ProductInfoRequestFixture.get(productId, couponIds));
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_PRODUCT_ID);
    }


    @DisplayName("couponIds가 비어있는 경우")
    @Test
    void coupon_ids_is_empty() {
        int productId = 1;
        int[] couponIds = {};

        // expect exception
        AntigravityApplicationException e = Assertions.assertThrows(AntigravityApplicationException.class, () -> ProductInfoRequestFixture.get(productId, couponIds));
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_COUPON_IDS);
    }

    @DisplayName("couponIds에 음수가 포함된 경우")
    @Test
    void coupon_ids_in_negative() {
        int productId = 1;
        int[] couponIds = {1, -2};

        // expect exception
        AntigravityApplicationException e = Assertions.assertThrows(AntigravityApplicationException.class, () -> ProductInfoRequestFixture.get(productId, couponIds));
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_COUPON_IDS);
    }
}
