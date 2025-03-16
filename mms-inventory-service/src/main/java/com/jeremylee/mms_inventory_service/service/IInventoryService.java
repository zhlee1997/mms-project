package com.jeremylee.mms_inventory_service.service;

import java.util.List;

import com.jeremylee.mms_inventory_service.model.Product;
import com.jeremylee.mms_inventory_service.request.CreateProductRequest;

public interface IInventoryService {
    // TODO: Pagination
    List<Product> getAllProducts();

    Product getProductById(String id);

    Product createProduct(CreateProductRequest product);

    Product updateProduct(String id, CreateProductRequest product);

    void deleteProduct(String id);
}
