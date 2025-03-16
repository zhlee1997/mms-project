package com.jeremylee.mms_inventory_service.service;

import com.jeremylee.mms_inventory_service.exception.ProductNotFoundException;
import com.jeremylee.mms_inventory_service.model.Product;
import com.jeremylee.mms_inventory_service.repository.InventoryRepository;
import com.jeremylee.mms_inventory_service.request.CreateProductRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return inventoryRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String id) {
        try {
            long productId = Long.parseLong(id);
            return inventoryRepository.getProductById(productId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid product ID: " + id, e);
        }
    }

    @Override
    public Product createProduct(CreateProductRequest product) {
        // TODO: Validate if product already exists by code, name
        Product productModel = new Product();
        productModel.setCode(product.getCode());
        productModel.setName(product.getName());
        productModel.setDescription(product.getDescription());
        productModel.setCategory(product.getCategory());
        productModel.setBrand(product.getBrand());
        productModel.setSupplierId(product.getSupplierId());
        productModel.setQuantityInStock(product.getQuantityInStock());
        productModel.setReorderLevel(product.getReorderLevel());
        productModel.setUnitPrice(product.getUnitPrice());
        productModel.setCostPrice(product.getCostPrice());
        productModel.setImageUrl(product.getImageUrl());

        int rowsInserted = inventoryRepository.createProduct(productModel);
        if (rowsInserted > 0) {
            return productModel; // Now contains the generated ID
        }
        throw new RuntimeException("Failed to insert product");
    }

    @Override
    public Product updateProduct(String id, CreateProductRequest product) {
        Optional<Product> existingProduct = Optional.ofNullable(getProductById(id));
        if (existingProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found: " + id);
        }

        Product productModel = existingProduct.get();
        productModel.setCode(product.getCode());
        productModel.setName(product.getName());
        productModel.setDescription(product.getDescription());
        productModel.setCategory(product.getCategory());
        productModel.setBrand(product.getBrand());
        productModel.setSupplierId(product.getSupplierId());
        productModel.setQuantityInStock(product.getQuantityInStock());
        productModel.setReorderLevel(product.getReorderLevel());
        productModel.setUnitPrice(product.getUnitPrice());
        productModel.setCostPrice(product.getCostPrice());
        productModel.setImageUrl(product.getImageUrl());

        long productId = Long.parseLong(id);
        int rowsUpdated = inventoryRepository.updateProduct(productModel, productId);
        if (rowsUpdated > 0) {
            return productModel;
        }
        throw new RuntimeException("Failed to update product");

    }

    @Override
    public void deleteProduct(String id) {
        long productId = Long.parseLong(id);
        int rowsDeleted = inventoryRepository.deleteProduct(productId);
        if (rowsDeleted == 0) {
            throw new ProductNotFoundException("Product not found: " + id);
        }
    }

}
