package antigravity.service;

import antigravity.domain.entity.Product;
import antigravity.exception.AntigravityApplicationException;
import antigravity.exception.ErrorCode;
import antigravity.model.request.ProductInfoRequest;
import antigravity.model.response.ProductAmountResponse;
import antigravity.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductAmountResponse getProductAmount(ProductInfoRequest request) {
        System.out.println("상품 가격 추출 로직을 완성 시켜주세요.");

        repository.getProduct(request.getProductId()).orElseThrow(() -> new AntigravityApplicationException(ErrorCode.PRODUCT_NOT_FOUND, String.format("Product Id %d not found.", request.getProductId())));

        return null;
    }
}
