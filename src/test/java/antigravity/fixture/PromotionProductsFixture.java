package antigravity.fixture;

import antigravity.domain.entity.PromotionProducts;

import java.util.ArrayList;
import java.util.List;

public class PromotionProductsFixture {

    public static List<PromotionProducts> select(int... ids) {
        List<PromotionProducts> list = new ArrayList<>();
        PromotionProducts pp1 = PromotionProducts.builder()
                .id(1)
                .promotionId(1)
                .productId(1)
                .build();
        PromotionProducts pp2 = PromotionProducts.builder()
                .id(1)
                .promotionId(2)
                .productId(1)
                .build();
        for (int id : ids) {
            if (id == 1) {
                list.add(pp1);
            }
            if (id == 2) {
                list.add(pp2);
            }
        }
        return list;
    }
}
