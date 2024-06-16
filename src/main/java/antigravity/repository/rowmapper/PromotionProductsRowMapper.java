package antigravity.repository.rowmapper;

import antigravity.domain.entity.PromotionProducts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PromotionProductsRowMapper implements RowMapper<PromotionProducts> {

    @Override
    public PromotionProducts mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PromotionProducts.builder()
                .id(rs.getInt("id"))
                .promotionId(rs.getInt("promotion_id"))
                .productId(rs.getInt("product_id"))
                .build();
    }
}
