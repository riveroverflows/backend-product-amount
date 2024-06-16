package antigravity.fixture;

import antigravity.domain.entity.Promotion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PromotionFixture {

    public static List<Promotion> select(int... ids) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Promotion> list = new ArrayList<>();
        Promotion promotion1 = Promotion.builder()
                .id(1)
                .promotionType("COUPON")
                .name("30000원 할인쿠폰")
                .discountType("WON")
                .discountValue(30000)
                .useStartedAt(LocalDate.parse("2022-11-01", formatter))
                .useEndedAt(LocalDate.parse("2025-03-01", formatter))
                .build();
        Promotion promotion2 = Promotion.builder()
                .id(2)
                .promotionType("CODE")
                .name("15% 할인코드")
                .discountType("PERCENT")
                .discountValue(15)
                .useStartedAt(LocalDate.parse("2022-11-01", formatter))
                .useEndedAt(LocalDate.parse("2025-03-01", formatter))
                .build();
        for (int id : ids) {
            if (id == 1) {
                list.add(promotion1);
            }
            if (id == 2) {
                list.add(promotion2);
            }
        }
        return list;
    }
}
