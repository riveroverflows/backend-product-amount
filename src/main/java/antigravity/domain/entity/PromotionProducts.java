package antigravity.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PromotionProducts {
    private int id;
    private int promotionId;
    private int productId;
}
