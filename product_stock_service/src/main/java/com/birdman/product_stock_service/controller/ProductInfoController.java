package com.birdman.product_stock_service.controller;

import com.birdman.product_stock_service.model.ProductInfo;
import com.birdman.product_stock_service.proxy.ProductInfoProxy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/access")
public class ProductInfoController {

    private ProductInfoProxy productInfoProxy;

    public ProductInfoController(ProductInfoProxy productInfoProxy) {
        this.productInfoProxy = productInfoProxy;
    }

    @GetMapping("/access-product-info")
    public ProductInfo accessProductInfo() {
        refreshActuator();
        return new ProductInfo(productInfoProxy.getName(), productInfoProxy.getDescription());
    }

    private void refreshActuator() {
        String baseURI = "http://localhost:8100/actuator/refresh";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> result = restTemplate.postForEntity(baseURI, entity, String.class);
    }
}
