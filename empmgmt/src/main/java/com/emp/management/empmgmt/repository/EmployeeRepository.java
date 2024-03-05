package com.emp.management.empmgmt.repository;

import com.emp.management.empmgmt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmpCode(Long empCode);

    void deleteByEmpId(Long empCode);
}
