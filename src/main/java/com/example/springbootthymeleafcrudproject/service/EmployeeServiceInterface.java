package com.example.springbootthymeleafcrudproject.service;

import com.example.springbootthymeleafcrudproject.model.Employees;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeServiceInterface  {
    List<Employees> getAllEmployees();
    void saveEmployee(Employees employee);
    Employees getEmployeeById(long id);

    void deleteEmployeeById(long id);

    // method for pagination
    Page<Employees> findPaginated (int pageNo, int pageSize, String sortField, String sortDirection);
}
