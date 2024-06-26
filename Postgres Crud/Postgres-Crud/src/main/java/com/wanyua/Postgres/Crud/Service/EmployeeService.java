package com.wanyua.Postgres.Crud.Service;

import com.wanyua.Postgres.Crud.DTO.EmployeeDto;
import com.wanyua.Postgres.Crud.Repository.EmployeeRepo;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
