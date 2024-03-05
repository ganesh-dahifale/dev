package com.emp.management.empmgmt.service.impl;

import com.emp.management.empmgmt.dto.EmployeeDto;
import com.emp.management.empmgmt.entity.Employee;
import com.emp.management.empmgmt.exception.EmployeeAlreadyPresentException;
import com.emp.management.empmgmt.exception.ResourceNotFoundException;
import com.emp.management.empmgmt.mapper.EmployeMapper;
import com.emp.management.empmgmt.repository.EmployeeRepository;
import com.emp.management.empmgmt.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        Employee employee = EmployeMapper.mapToEmployee(employeeDto,new Employee());
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(employeeDto.getEmpCode());
        if(optionalEmployee.isPresent()){
            throw new EmployeeAlreadyPresentException("employee already present with the give employee id "+employeeDto.getEmpCode());
        }
        employeeRepository.save(employee);

    }

    @Override
    public EmployeeDto fetch(Long empCode) {
        Employee employee = employeeRepository.findByEmpCode(empCode).orElseThrow(
                () -> new ResourceNotFoundException("Employee","EmployeeCode",empCode)
        );
        return EmployeMapper.mapToEmployeeDto(employee,new EmployeeDto());
    }

    @Override
    public boolean update(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findByEmpCode(employeeDto.getEmpCode()).orElseThrow(
                () -> new ResourceNotFoundException("Employee","EmployeeCode",employeeDto.getEmpCode())
        );
        EmployeMapper.mapToEmployee(employeeDto,employee);
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean delete(Long empCode) {

        Employee employee = employeeRepository.findByEmpCode(empCode).orElseThrow(
                () -> new ResourceNotFoundException("Employee","EmployeeCode",empCode)
        );
        employeeRepository.deleteById(employee.getEmpId());
        return true;
    }
}
