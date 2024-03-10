package com.nauka.testassignment.implementation;

import com.nauka.testassignment.model.Employee;
import com.nauka.testassignment.repository.EmployeeRepository;
import com.nauka.testassignment.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {

        return repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {

        return repository.findById(id);
    }

    @Override
    public List<Map<String, List<Employee>>> groupByName() {

        return repository.groupByName();
    }

    @Override
    public List<Employee> findBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findBetween(startDate, endDate);
    }

}
