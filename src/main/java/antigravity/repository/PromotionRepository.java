package antigravity.repository;

import antigravity.domain.entity.Promotion;
import antigravity.domain.entity.PromotionProducts;
import antigravity.repository.rowmapper.PromotionProductsRowMapper;
import antigravity.repository.rowmapper.PromotionRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PromotionRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final PromotionRowMapper PROMOTION_ROW_MAPPER = new PromotionRowMapper();
    private static final PromotionProductsRowMapper PROMOTION_PRODUCTS_ROW_MAPPER = new PromotionProductsRowMapper();

    public List<Promotion> selectPromotions(List<Integer> ids) {
        String query = """
                SELECT *
                  FROM promotion
                 WHERE id IN (:ids)
                   AND NOW() BETWEEN use_started_at AND use_ended_at
                """;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ids", ids);
        return namedParameterJdbcTemplate.query(query, params, PROMOTION_ROW_MAPPER);
    }

    public List<PromotionProducts> selectPromotionProducts(int productId, List<Integer> promotionIds) {
        String query = """
                SELECT *
                  FROM promotion_products
                 WHERE product_id = :productId
                   AND promotion_id IN (:promotionIds)
                """;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId", productId);
        params.addValue("promotionIds", promotionIds);
        return namedParameterJdbcTemplate.query(query, params, PROMOTION_PRODUCTS_ROW_MAPPER);
    }
}
