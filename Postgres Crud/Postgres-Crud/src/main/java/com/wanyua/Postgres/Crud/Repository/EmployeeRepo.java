package com.wanyua.Postgres.Crud.Repository;

import com.wanyua.Postgres.Crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
