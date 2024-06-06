package com.wanyua.Postgres.Crud.Service;

import com.wanyua.Postgres.Crud.DTO.EmployeeDto;
import com.wanyua.Postgres.Crud.Repository.EmployeeRepo;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
