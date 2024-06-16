package antigravity.model.dto;

import antigravity.domain.entity.Product;
import antigravity.domain.entity.Promotion;
import antigravity.domain.entity.PromotionProducts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductAmountDto {
    private Product product;
    private List<PromotionProducts> promotionProducts;
    private List<Promotion> promotions;

    @Builder(builderMethodName = "of")
    public ProductAmountDto(Product product, List<PromotionProducts> promotionProducts, List<Promotion> promotions) {
        this.product = product;
        this.promotionProducts = promotionProducts;
        this.promotions = promotions;
    }
}
