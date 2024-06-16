package antigravity.factory;

import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import antigravity.strategy.FixedAmountDiscountStrategy;
import antigravity.strategy.PercentageDiscountStrategy;
import antigravity.strategy.PromotionStrategy;

public class PromotionStrategyFactory {
    public static PromotionStrategy getPromotionStrategy(String type, int discountValue) {
        return switch (type) {
            case "PERCENT" -> new PercentageDiscountStrategy(discountValue);
            case "WON" -> new FixedAmountDiscountStrategy(discountValue);
            default ->
                    throw new AntigravityApplicationException(ErrorCode.INVALID_PROMOTION_TYPE, "Invalid promotion type: " + type);
        };
    }
}
