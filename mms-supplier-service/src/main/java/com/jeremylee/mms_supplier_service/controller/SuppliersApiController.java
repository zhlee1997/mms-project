package com.jeremylee.mms_supplier_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.jeremylee.mms_supplier_service.model.Supplier;
import com.jeremylee.mms_supplier_service.model.SupplierRequest;
import com.jeremylee.mms_supplier_service.request.CreateSupplierRequest;
import com.jeremylee.mms_supplier_service.service.SupplierService;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-21T23:57:33.854025+08:00[Asia/Kuala_Lumpur]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPISupplierServiceOpenAPI30.base-path:}")
public class SuppliersApiController implements SuppliersApi {

    private final NativeWebRequest request;

    public SuppliersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Autowired
    private SupplierService supplierService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Supplier>> listSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @Override
    public ResponseEntity<Supplier> getSupplier(String supplierId) {
        return ResponseEntity.ok(supplierService.getSupplierById(supplierId));
    }

    @Override
    public ResponseEntity<Supplier> createSupplier(CreateSupplierRequest supplierRequest) {
        Supplier supplier = supplierService.createSupplier(supplierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplier);
    }
}
