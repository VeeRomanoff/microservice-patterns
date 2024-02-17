package com.birdman.product_stock_service.controller;

import com.birdman.product_stock_service.model.ProductStock;
import com.birdman.product_stock_service.proxy.ProductStockProxy;
import com.birdman.product_stock_service.repository.ProductStockRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ProductStockController {

    private final ProductStockRepository repository;
    private final Environment environment;

    public ProductStockController(ProductStockRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @PostMapping("/new-product")
    public ProductStock addProductStock(@RequestBody ProductStock productStock) {
        return repository.save(productStock);
    }

    @GetMapping("/check-product-stock/product-name/{productName}/product-availability/{productAvailability}")
    public ProductStockProxy checkProductStock(@PathVariable String productName,
                                               @PathVariable String productAvailability) {

        ProductStock productStock = repository.findByProductNameAndProductAvailability(productName, productAvailability);
        return new ProductStockProxy(productStock.getId(),
                productName,
                productStock.getProductPrice(),
                productAvailability,
                productStock.getDiscountOffer(),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")))
        );
    }
}
