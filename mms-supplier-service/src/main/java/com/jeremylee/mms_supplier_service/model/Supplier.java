package com.jeremylee.mms_supplier_service.model;

import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * Details of a supplier
 */

@Schema(name = "Supplier", description = "Details of a supplier")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-21T23:57:33.854025+08:00[Asia/Kuala_Lumpur]", comments = "Generator version: 7.9.0")
@Data
public class Supplier {
  private Long id;
  private String name;
  private String contactName;
  private String phone;
  private String email;
  private String address;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;
}
