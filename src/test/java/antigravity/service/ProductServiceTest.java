package antigravity.service;

import antigravity.domain.entity.Product;
import antigravity.domain.entity.Promotion;
import antigravity.domain.entity.PromotionProducts;
import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import antigravity.fixture.ProductFixture;
import antigravity.fixture.ProductInfoRequestFixture;
import antigravity.fixture.PromotionFixture;
import antigravity.fixture.PromotionProductsFixture;
import antigravity.model.request.ProductInfoRequest;
import antigravity.model.response.ProductAmountResponse;
import antigravity.repository.ProductRepository;
import antigravity.repository.PromotionRepository;
import antigravity.util.AntigravityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private PromotionRepository promotionRepository;

    @DisplayName("요청 상품 정보가 없을 경우")
    @Test
    void product_not_found() {
        // given
        ProductInfoRequest productInfoRequest = ProductInfoRequestFixture.get(1, 2);
        // when
        when(productRepository.getProduct(1)).thenReturn(Optional.empty());
        // then
        AntigravityApplicationException e = Assertions.assertThrows(AntigravityApplicationException.class, () -> productService.getProductAmount(productInfoRequest));
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.PRODUCT_NOT_FOUND);
    }

    @DisplayName("상품 가격 범위 벗어남")
    @Test
    void price_is_out_of_range() {
        // given
        ProductInfoRequest productInfoRequest = ProductInfoRequestFixture.get(1, 2);
        Product product = ProductFixture.get(1, 5000);
        // when
        when(productRepository.getProduct(product.getId())).thenReturn(Optional.of(product));
        // then
        AntigravityApplicationException e = Assertions.assertThrows(AntigravityApplicationException.class, () -> productService.getProductAmount(productInfoRequest));
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.PRICE_OUT_OF_RANGE);
    }

    @DisplayName("상품 가격 계산")
    @Test
    void calculate() {
        // given
        ProductInfoRequest request = ProductInfoRequestFixture.get(2);
        Product product = ProductFixture.get(1, 215000);
        List<Promotion> promotions = PromotionFixture.select(2);
        List<PromotionProducts> promotionProducts = PromotionProductsFixture.select(2);
        // when
        when(productRepository.getProduct(product.getId())).thenReturn(Optional.of(product));
        when(promotionRepository.selectPromotions(AntigravityUtils.arrayToList(request.getCouponIds()))).thenReturn(promotions);
        when(promotionRepository.selectPromotionProducts(product.getId(), AntigravityUtils.arrayToList(request.getCouponIds()))).thenReturn(promotionProducts);
        // then
        ProductAmountResponse productAmount = productService.getProductAmount(request);
        assertThat(productAmount.getFinalPrice()).isEqualTo(182_000);
    }
}