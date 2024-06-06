package com.wanyua.Postgres.Crud.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto { // Used as a response for rest APIs
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
