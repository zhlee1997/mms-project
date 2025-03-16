package com.jeremylee.mms_inventory_service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String brand;
    private String color;
    private String size;
}
