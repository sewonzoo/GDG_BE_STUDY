package com.example.shop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Map<String, Object> request) {
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/products/" + productId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllProducts() {
        List<Map<String, Object>> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Map<String, Object>> getProduct(@PathVariable Long productId) {
        Map<String, Object> product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody Map<String, Object> request
    ) {
        productService.updateProduct(productId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}