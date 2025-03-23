package com.jeremylee.mms_inventory_service.model.supplier;

import lombok.Data;

@Data
public class CreateSupplierRequest {
    private String name;
    private String contactName;
    private String phone;
    private String email;
    private String address;
}
