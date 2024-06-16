package antigravity.service;

import antigravity.exception.AntigravityApplicationException;
import antigravity.fixture.ProductInfoRequestFixture;
import antigravity.model.request.ProductInfoRequest;
import antigravity.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @DisplayName("요청 상품 정보가 없을 경우")
    @Test
    void product_not_found() {
        ProductInfoRequest productInfoRequest = ProductInfoRequestFixture.get();
        when(productRepository.getProduct(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(AntigravityApplicationException.class, () -> productService.getProductAmount(productInfoRequest));
    }
}