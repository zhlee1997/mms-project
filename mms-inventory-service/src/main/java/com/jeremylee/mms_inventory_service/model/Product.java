package com.jeremylee.mms_inventory_service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {

    private Long id;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
