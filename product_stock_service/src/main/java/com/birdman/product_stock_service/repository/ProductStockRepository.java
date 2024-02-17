package com.birdman.product_stock_service.repository;

import com.birdman.product_stock_service.model.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
    ProductStock findByProductNameAndProductAvailability(String productName, String productAvailability);
}
