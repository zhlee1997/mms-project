package com.jeremylee.mms_supplier_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremylee.mms_supplier_service.model.Supplier;
import com.jeremylee.mms_supplier_service.repository.SupplierRepository;
import com.jeremylee.mms_supplier_service.request.CreateSupplierRequest;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.getAllSuppliers();
    }

    @Override
    public Supplier getSupplierById(String id) {
        try {
            long supplierId = Long.parseLong(id);
            return supplierRepository.getSupplierById(supplierId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid supplier ID: " + id, e);
        }
    }

    @Override
    public Supplier createSupplier(CreateSupplierRequest supplier) {
        Supplier supplierModel = new Supplier();
        supplierModel.setName(supplier.getName());
        supplierModel.setContactName(supplier.getContactName());
        supplierModel.setPhone(supplier.getPhone());
        supplierModel.setEmail(supplier.getEmail());
        // supplierModel.setEmail(JsonNullable.of(supplier.getEmail()));
        supplierModel.setAddress(supplier.getAddress());
        // supplierModel.setAddress(JsonNullable.of(supplier.getAddress()));

        int rowsInserted = supplierRepository.createSupplier(supplierModel);
        if (rowsInserted > 0) {
            return supplierModel;
        } else {
            throw new RuntimeException("Failed to create supplier");
        }
    }

    @Override
    public Supplier updateSupplier(String id, CreateSupplierRequest supplier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSupplier'");
    }

    @Override
    public void deleteSupplier(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSupplier'");
    }

}
