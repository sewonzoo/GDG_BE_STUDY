package com.example.shop.order;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    public Long createOrder(Map<String, Object> request) {
        // 실제로는 주문 생성 로직 수행
        return 1L;
    }

    public List<Map<String, Object>> getAllOrders() {
        // 실제로는 Repository에서 주문 목록 조회
        return new ArrayList<>();
    }

    public Map<String, Object> getOrderById(Long orderId) {
        // 실제로는 Repository에서 주문 단건 조회
        Map<String, Object> order = new HashMap<>();
        order.put("id", orderId);
        order.put("memberId", 1L);
        order.put("productId", 1L);
        order.put("quantity", 2);
        order.put("status", "CREATED");
        return order;
    }

    public void cancelOrder(Long orderId) {
        // 실제로는 주문 상태를 CANCELLED로 변경하는 로직 수행
    }
}