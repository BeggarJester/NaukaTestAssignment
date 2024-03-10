package com.nauka.testassignment.service;

import com.nauka.testassignment.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Optional<Employee> findById(Integer id);

    List<Map<String, List<Employee>>> groupByName();

    List<Employee> findBetween(LocalDate startDate, LocalDate endDate);
}
