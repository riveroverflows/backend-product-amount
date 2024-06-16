package antigravity.repository.rowmapper;

import antigravity.domain.entity.Promotion;
import antigravity.util.AntigravityUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class PromotionRowMapper implements RowMapper<Promotion> {


    @Override
    public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Promotion.builder()
                .id(rs.getInt("id"))
                .promotionType(rs.getString("promotion_type"))
                .name(rs.getString("name"))
                .discountType(rs.getString("discount_type"))
                .discountValue(rs.getInt("discount_value"))
                .useStartedAt(LocalDate.parse(rs.getString("use_started_at"), AntigravityUtils.DATE_FORMATTER))
                .useEndedAt(LocalDate.parse(rs.getString("use_ended_at"), AntigravityUtils.DATE_FORMATTER))
                .build();
    }
}
