package com.Prograd.SpringBoot.springbootbackend.Security;

import com.Prograd.SpringBoot.springbootbackend.Models.Employee;
import com.Prograd.SpringBoot.springbootbackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Employee employee= this.employeeRepository.findByEmail(username).orElseThrow();
       return employee;
    }

}
