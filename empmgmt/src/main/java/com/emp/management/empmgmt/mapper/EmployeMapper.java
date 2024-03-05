package com.emp.management.empmgmt.mapper;

import com.emp.management.empmgmt.dto.EmployeeDto;
import com.emp.management.empmgmt.entity.Employee;

public class EmployeMapper {
    public static Employee mapToEmployee(EmployeeDto employeeDto,Employee employee){
        employee.setEmpCode(employeeDto.getEmpCode());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setCity(employeeDto.getCity());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        return employee;
    }
    public static EmployeeDto mapToEmployeeDto(Employee employee,EmployeeDto employeeDto){
        employeeDto.setEmpCode(employee.getEmpCode());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setCity(employee.getCity());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        return employeeDto;
    }
}
