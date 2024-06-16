package antigravity.fixture;

import antigravity.model.request.ProductInfoRequest;

public class ProductInfoRequestFixture {
    public static ProductInfoRequest get() {
        return ProductInfoRequest.builder()
                .productId(1)
                .couponIds(new int[]{1, 2})
                .build();
    }
}
