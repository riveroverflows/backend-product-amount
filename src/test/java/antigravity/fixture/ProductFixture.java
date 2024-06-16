package antigravity.fixture;

import antigravity.domain.entity.Product;
import antigravity.model.request.ProductInfoRequest;

public class ProductFixture {
    public static Product get(int id, int price) {
        return Product.builder()
                .id(id)
                .name("product")
                .price(price)
                .build();
    }
}
