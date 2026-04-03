package com.example.shop.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public Long createProduct(Map<String, Object> request) {
        // 실제로는 Repository에 저장 후 생성된 상품 ID를 반환
        return 1L;
    }

    public List<Map<String, Object>> getAllProducts() {
        // 실제로는 Repository에서 전체 상품 목록 조회
        return new ArrayList<>();
    }

    public Map<String, Object> getProductById(Long productId) {
        // 실제로는 Repository에서 상품 단건 조회
        Map<String, Object> product = new HashMap<>();
        product.put("id", productId);
        product.put("name", "sample product");
        product.put("price", 10000);
        product.put("stock", 50);
        return product;
    }

    public void updateProduct(Long productId, Map<String, Object> request) {
        // 실제로는 상품 조회 후 수정 로직 수행
    }

    public void deleteProduct(Long productId) {
        // 실제로는 상품 삭제 로직 수행
    }
}