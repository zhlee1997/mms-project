package com.jeremylee.mms_supplier_service.repository;

import com.jeremylee.mms_supplier_service.model.Supplier;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierRepository {

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(@Param("supplierId") long id);

    int createSupplier(Supplier supplier);

    int updateSupplier(@Param("supplier") Supplier supplier, @Param("id") long id);

    int deleteSupplier(@Param("id") long id);

}
