package antigravity.service;

import antigravity.domain.entity.Promotion;
import antigravity.factory.PromotionStrategyFactory;
import antigravity.strategy.PromotionStrategy;

public class PromotionCalculator {
    private final PromotionStrategy promotionStrategy;

    public PromotionCalculator(Promotion promotion) {
        this.promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotion.getDiscountType(), promotion.getDiscountValue());
    }

    public double calculate(double price) {
        return promotionStrategy.calculate(price);
    }
}
