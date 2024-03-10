package com.nauka.testassignment.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private Double salary;
}
