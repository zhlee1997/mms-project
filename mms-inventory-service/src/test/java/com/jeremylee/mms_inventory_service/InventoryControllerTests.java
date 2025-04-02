// package com.jeremylee.mms_inventory_service;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// // import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.web.servlet.MockMvc;

// import com.jeremylee.mms_inventory_service.controller.InventoryController;
// import com.jeremylee.mms_inventory_service.model.Product;

// @WebMvcTest(InventoryController.class)
// @AutoConfigureMockMvc
// class InventoryControllerTests {

// @Autowired
// MockMvc mockMvc;

// List<Product> products = new ArrayList<>();

// @BeforeEach
// void setUp() {

// // {
// // "id": 2,
// // "code": "P001",
// // "name": "Cordless Drill",
// // "description": null,
// // "category": "Power Tools",
// // "brand": "Bosch",
// // "supplierId": 1,
// // "quantityInStock": 50,
// // "reorderLevel": 10,
// // "unitPrice": 129.99,
// // "costPrice": 89.99,
// // "imageUrl": null,
// // "createdAt": "2025-03-16T02:47:02.24226",
// // "updatedAt": "2025-03-16T02:47:02.24226"
// // }
// products = List.of();
// }

// // REST API
// @Test
// void shouldFindAllProducts() throws Exception {
// // mockMvc.perform(get("/inventory/products")).andExpect(status().isOk());
// }

// }
