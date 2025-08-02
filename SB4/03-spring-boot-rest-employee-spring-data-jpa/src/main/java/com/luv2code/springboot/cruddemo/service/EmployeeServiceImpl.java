package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired EmployeeServiceImpl(EmployeeRepository EmployeeRepository)
    {
        this.employeeRepository = EmployeeRepository;
    }

	@Override
	public List<Employee> findAll() {
	return employeeRepository.findAll();
	}

    @Override
    public Employee findByID(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee thEmployee = null;
        if(result.isPresent())
        {
            thEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find the employee ID - "+theId);
        }
        return thEmployee;
    }

    @Override
    public Employee save(Employee thEmployee) {
        return employeeRepository.save(thEmployee);
    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
}
