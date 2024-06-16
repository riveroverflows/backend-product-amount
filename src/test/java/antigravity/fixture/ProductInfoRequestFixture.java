package antigravity.fixture;

import antigravity.model.request.ProductInfoRequest;

public class ProductInfoRequestFixture {
    public static ProductInfoRequest get(int... couponIds) {
        return ProductInfoRequest.builder()
                .productId(1)
                .couponIds(couponIds)
                .build();
    }
}
