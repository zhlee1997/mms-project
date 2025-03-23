package com.jeremylee.mms_inventory_service.model.supplier;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Supplier {
    private Long id;
    private String name;
    private String contactName;
    private String phone;
    private String email;
    private String address;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;
}
