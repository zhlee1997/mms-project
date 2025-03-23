package com.jeremylee.mms_supplier_service.service;

import java.util.List;

import com.jeremylee.mms_supplier_service.model.Supplier;
import com.jeremylee.mms_supplier_service.request.CreateSupplierRequest;

public interface ISupplierService {
    // TODO: Pagination
    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(String id);

    Supplier createSupplier(CreateSupplierRequest supplier);

    Supplier updateSupplier(String id, CreateSupplierRequest supplier);

    void deleteSupplier(String id);
}
