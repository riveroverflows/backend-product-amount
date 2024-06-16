package antigravity.service;

import antigravity.domain.entity.Product;
import antigravity.domain.entity.Promotion;
import antigravity.domain.entity.PromotionProducts;
import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import antigravity.model.dto.ProductAmountDto;
import antigravity.model.request.ProductInfoRequest;
import antigravity.model.response.ProductAmountResponse;
import antigravity.repository.ProductRepository;
import antigravity.repository.PromotionRepository;
import antigravity.util.AntigravityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;

    public ProductAmountResponse getProductAmount(ProductInfoRequest request) {
        ProductAmountDto amountDto = validateAndReturnDto(request);

        repository.getProduct(request.getProductId()).orElseThrow(() -> new AntigravityApplicationException(ErrorCode.PRODUCT_NOT_FOUND, String.format("Product Id %d not found.", request.getProductId())));

        return null;

    private ProductAmountDto validateAndReturnDto(ProductInfoRequest request) {
        Product product = productRepository.getProduct(request.getProductId())
                .orElseThrow(() -> new AntigravityApplicationException(ErrorCode.PRODUCT_NOT_FOUND, "request info: " + request));
        product.validatePrice();

        List<PromotionProducts> promotionProducts = promotionRepository.selectPromotionProducts(request.getProductId(), AntigravityUtils.arrayToList(request.getCouponIds()));
        if (!request.isCouponIdsLengthEqual(promotionProducts.size())) {
            throw new AntigravityApplicationException(ErrorCode.PROMOTION_PRODUCTS_NOT_FOUND, "request info: " + request);
        }

        List<Promotion> promotions = promotionRepository.selectPromotions(AntigravityUtils.arrayToList(request.getCouponIds()));
        if (!request.isCouponIdsLengthEqual(promotions.size())) {
            throw new AntigravityApplicationException(ErrorCode.PROMOTION_NOT_FOUND, "request info: " + request);
        }

        return ProductAmountDto.of()
                .product(product)
                .promotionProducts(promotionProducts)
                .promotions(promotions)
                .build();
    }
}
