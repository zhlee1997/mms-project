package com.jeremylee.mms_inventory_service.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String code;
    private String name;
    private String description;

    private String category;
    private String brand;
    private Long supplierId;
    private Integer quantityInStock;

    private Integer reorderLevel;
    private BigDecimal unitPrice;
    private BigDecimal costPrice;
    private String imageUrl;
}
