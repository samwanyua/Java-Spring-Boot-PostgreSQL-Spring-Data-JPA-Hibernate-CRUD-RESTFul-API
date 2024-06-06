package com.wanyua.Postgres.Crud.Service.Impl;

import com.wanyua.Postgres.Crud.DTO.EmployeeDto;
import com.wanyua.Postgres.Crud.Entity.Employee;
import com.wanyua.Postgres.Crud.Mapper.EmployeeMapper;
import com.wanyua.Postgres.Crud.Repository.EmployeeRepo;
import com.wanyua.Postgres.Crud.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
