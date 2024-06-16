package antigravity.strategy;

public class FixedAmountDiscountStrategy implements PromotionStrategy {
    private final int discountValue;

    public FixedAmountDiscountStrategy(int discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public double calculate(double price) {
        return price - discountValue;
    }
}
