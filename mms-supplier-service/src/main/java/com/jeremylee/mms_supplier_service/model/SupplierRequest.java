package com.jeremylee.mms_supplier_service.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Request payload for creating or updating a supplier
 */

@Schema(name = "SupplierRequest", description = "Request payload for creating or updating a supplier")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-21T23:57:33.854025+08:00[Asia/Kuala_Lumpur]", comments = "Generator version: 7.9.0")
public class SupplierRequest {

  private String name;

  private String contactName;

  private String phone;

  private JsonNullable<String> email = JsonNullable.<String>undefined();

  private JsonNullable<String> address = JsonNullable.<String>undefined();

  public SupplierRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Supplier name
   * @return name
   */
  
  @Schema(name = "name", description = "Supplier name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SupplierRequest contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * Contact person
   * @return contactName
   */
  
  @Schema(name = "contact_name", description = "Contact person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contact_name")
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public SupplierRequest phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Contact number
   * @return phone
   */
  
  @Schema(name = "phone", description = "Contact number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public SupplierRequest email(String email) {
    this.email = JsonNullable.of(email);
    return this;
  }

  /**
   * Supplier email (optional)
   * @return email
   */
  
  @Schema(name = "email", description = "Supplier email (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public JsonNullable<String> getEmail() {
    return email;
  }

  public void setEmail(JsonNullable<String> email) {
    this.email = email;
  }

  public SupplierRequest address(String address) {
    this.address = JsonNullable.of(address);
    return this;
  }

  /**
   * Supplier address
   * @return address
   */
  
  @Schema(name = "address", description = "Supplier address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public JsonNullable<String> getAddress() {
    return address;
  }

  public void setAddress(JsonNullable<String> address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupplierRequest supplierRequest = (SupplierRequest) o;
    return Objects.equals(this.name, supplierRequest.name) &&
        Objects.equals(this.contactName, supplierRequest.contactName) &&
        Objects.equals(this.phone, supplierRequest.phone) &&
        equalsNullable(this.email, supplierRequest.email) &&
        equalsNullable(this.address, supplierRequest.address);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, contactName, phone, hashCodeNullable(email), hashCodeNullable(address));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupplierRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

