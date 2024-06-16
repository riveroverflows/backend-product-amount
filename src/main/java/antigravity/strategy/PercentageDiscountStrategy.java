package antigravity.strategy;

public class PercentageDiscountStrategy implements PromotionStrategy {
    private final int discountValue;

    public PercentageDiscountStrategy(int discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public double calculate(double price) {
        return price - ((price * discountValue) / 100);
    }
}
