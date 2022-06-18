package com.Prograd.SpringBoot.springbootbackend.Service;

import com.Prograd.SpringBoot.springbootbackend.Models.Employee;
import com.Prograd.SpringBoot.springbootbackend.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        //super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).orElseThrow();
    }
    @Override
    public Employee updateEmployee(Employee employee,int id)
    {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
    @Override
    public void deleteEmployee(int id)
    {
        employeeRepository.findById(id).orElseThrow();
        employeeRepository.deleteById(id);
    }


}
