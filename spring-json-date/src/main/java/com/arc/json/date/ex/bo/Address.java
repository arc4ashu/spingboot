package com.arc.json.date.ex.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
