package com.Prograd.SpringBoot.springbootbackend.Repository;

import com.Prograd.SpringBoot.springbootbackend.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmail(String email);
}
