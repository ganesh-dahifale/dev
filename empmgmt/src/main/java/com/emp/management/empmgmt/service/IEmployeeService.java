package com.emp.management.empmgmt.service;

import com.emp.management.empmgmt.dto.EmployeeDto;
import com.emp.management.empmgmt.entity.Employee;

public interface IEmployeeService {
    void create(EmployeeDto employeeDto);

    EmployeeDto fetch(Long empCode);

    boolean update(EmployeeDto employeeDto);

    boolean delete(Long empCode);
}
