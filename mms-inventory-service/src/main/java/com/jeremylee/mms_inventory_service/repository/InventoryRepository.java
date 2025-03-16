package com.jeremylee.mms_inventory_service.repository;

import com.jeremylee.mms_inventory_service.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryRepository {

    List<Product> getAllProducts();

    Product getProductById(@Param("id") long id);

    int createProduct(Product product);

    int updateProduct(@Param("product") Product product, @Param("id") long id);

    int deleteProduct(@Param("id") long id);

}
