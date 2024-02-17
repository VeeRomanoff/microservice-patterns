package com.birdman.product_stock_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_stock")
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "product_availability", nullable = false)
    private String productAvailability;

    @Column(name = "discount_offer", nullable = false)
    private BigDecimal discountOffer;

    public ProductStock() {
    }

    public ProductStock(String productName, Integer productPrice, String productAvailability, BigDecimal discountOffer) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAvailability = productAvailability;
        this.discountOffer = discountOffer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(String productAvailability) {
        this.productAvailability = productAvailability;
    }

    public BigDecimal getDiscountOffer() {
        return discountOffer;
    }

    public void setDiscountOffer(BigDecimal discountOffer) {
        this.discountOffer = discountOffer;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAvailability='" + productAvailability + '\'' +
                ", discountOffer=" + discountOffer +
                '}';
    }
}
