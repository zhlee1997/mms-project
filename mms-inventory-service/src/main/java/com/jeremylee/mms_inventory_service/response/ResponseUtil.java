package com.jeremylee.mms_inventory_service.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<BaseResponse<T>> success(T data, String message) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK, message, data));
    }

    public static <T> ResponseEntity<BaseResponse<T>> success(String message) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK, message));
    }

    public static <T> ResponseEntity<BaseResponse<T>> created(T data, String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED, message, data));
    }

    public static <T> ResponseEntity<BaseResponse<T>> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new BaseResponse<>(status, message));
    }
}
