package com.nauka.testassignment.repository;

import com.nauka.testassignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(Integer id);

    default List<Map<String, List<Employee>>> groupByName() {
        List<Employee> allEmployees = findAll();
        var map = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        List<Map<String, List<Employee>>> result = new ArrayList<>();
        result.add(map);
        return result;
    }

    default List<Employee> findBetween(LocalDate startDate, LocalDate endDate) {
        List<Employee> allEmployees = findAll();

        allEmployees.removeIf(employee -> {
            LocalDate dateOfBirth = employee.getDateOfBirth();
            return dateOfBirth == null || dateOfBirth.isBefore(startDate) || dateOfBirth.isAfter(endDate);
        });

        return allEmployees;
    }
}
