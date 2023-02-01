package com.example.springbootthymeleafcrudproject.repository;

import com.example.springbootthymeleafcrudproject.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}
