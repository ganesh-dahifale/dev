package com.emp.management.empmgmt.dto;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
public class EmployeeDto {
    private Long empCode;
    private String firstName;
    private String lastName;
    private String city;
    private String mobileNumber;
}
