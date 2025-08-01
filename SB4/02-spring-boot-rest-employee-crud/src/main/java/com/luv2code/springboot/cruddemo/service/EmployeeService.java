package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theId);
    Employee save(Employee thEmployee);
    void delete(int theId);   
}