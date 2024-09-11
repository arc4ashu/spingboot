package com.arc.json.date.ex.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private Address address;

}
