package com.jeremylee.mms_inventory_service.controller;

import com.jeremylee.mms_inventory_service.model.Product;
import com.jeremylee.mms_inventory_service.request.CreateProductRequest;
import com.jeremylee.mms_inventory_service.response.BaseResponse;
import com.jeremylee.mms_inventory_service.response.ResponseUtil;
import com.jeremylee.mms_inventory_service.service.InventoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    @Operation(summary = "Welcome to the inventory service", description = "Welcome message")
    @ApiResponse(responseCode = "200", description = "Welcome message")
    public String index() {
        return "Welcome to the inventory service!";
    }

    /**
     * GET /products : List all inventory products
     *
     * @return List of inventory products (status code 200)
     */
    @GetMapping("/products")
    @Operation(summary = "Get all inventory products", description = "Fetches a list of all available products in the inventory.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the product list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BaseResponse<List<Product>>> getAllProducts() {
        try {
            logger.info("Fetching all products from the inventory-service");
            return ResponseUtil.success(inventoryService.getAllProducts(), "Successfully retrieved the product list");
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // Get product by id
    // returns a product
    @GetMapping("/product/{productId}")
    @Operation(summary = "Get product by ID", description = "Fetches a product by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the product"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BaseResponse<Product>> getProductById(@PathVariable("productId") String productId) {
        try {
            logger.info("Fetching product by ID from the inventory-service: " + productId);
            return ResponseUtil.success(inventoryService.getProductById(productId),
                    "Successfully retrieved the product");
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // creare product
    // returns a product
    @PostMapping("/product/create")
    @Operation(summary = "Create a new product", description = "Creates a new product in the inventory.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Successfully created the product"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BaseResponse<Product>> createNewProduct(@RequestBody CreateProductRequest newProduct) {
        try {
            logger.info("Creating new product at the inventory-service: " + newProduct.toString());
            return ResponseUtil.created(inventoryService.createProduct(newProduct),
                    "Successfully created the product");
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // update product
    // returns a product
    @PutMapping("/product/update")
    @Operation(summary = "Update a product", description = "Updates a product in the inventory.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully updated the product"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BaseResponse<Product>> updateProduct(@RequestBody CreateProductRequest updatedProduct,
            @RequestParam String productId) {
        try {
            logger.info("Updating product: {} at the inventory-service: {}", productId, updatedProduct);
            return ResponseUtil.success(inventoryService.updateProduct(productId, updatedProduct),
                    "Successfully updated the product");
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // delete product
    // returns a string
    @DeleteMapping("/product/delete/{productId}")
    @Operation(summary = "Delete a product", description = "Deletes a product from the inventory.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully deleted the product"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BaseResponse<String>> deleteProduct(@PathVariable("productId") String productId) {
        try {
            logger.info("Deleting product by ID from the inventory-service: " + productId);
            inventoryService.deleteProduct(productId);
            return ResponseUtil.success("Successfully deleted the product");
        } catch (Exception e) {
            return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
