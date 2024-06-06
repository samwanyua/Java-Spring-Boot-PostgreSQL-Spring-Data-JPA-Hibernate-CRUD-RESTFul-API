package com.wanyua.Postgres.Crud.Service.Impl;

import com.wanyua.Postgres.Crud.DTO.EmployeeDto;
import com.wanyua.Postgres.Crud.Entity.Employee;
import com.wanyua.Postgres.Crud.Exception.ResourceNotFoundException;
import com.wanyua.Postgres.Crud.Mapper.EmployeeMapper;
import com.wanyua.Postgres.Crud.Repository.EmployeeRepo;
import com.wanyua.Postgres.Crud.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee) {
       Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       Employee updatedEmployeeObject = employeeRepo.save(employee);

       return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObject);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        employeeRepo.deleteById(employeeId);
    }
}
