package com.nauka.testassignment.controller;

import com.nauka.testassignment.model.Employee;
import com.nauka.testassignment.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("add_employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return service.addEmployee(employee);
    }


    @GetMapping("find_by_id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return service.findById(id).isPresent()
                ? ResponseEntity.ok(service.findById(id))
                : ResponseEntity.badRequest().body("The employee with this ID is not contained in the table.");
    }

    @GetMapping("group_by_name")
    public List<Map<String, List<Employee>>> groupByName() {
        return service.groupByName();
    }

    @GetMapping("find_between/{startYear}-{endYear}")
    public List<Employee> findBetween(@PathVariable int startYear, @PathVariable int endYear) {
        return service.findBetween(LocalDate.of(startYear, 1, 1), LocalDate.of(endYear, 12, 31));
    }

}
