package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

	@Override
	public List<Employee> findAll() {
	return employeeDAO.findAll();
	}

    @Override
    public Employee findByID(int theId) {
        return employeeDAO.findByID(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee thEmployee) {
        return employeeDAO.save(thEmployee);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        employeeDAO.delete(theId);
    }
}
