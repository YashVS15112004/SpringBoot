package com.luv2code.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService,ObjectMapper theObjectMapper)
    {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id)
    {
        Employee theEmployee = employeeService.findByID(id);
        if(theEmployee == null) throw new RuntimeException("Employee with id "+" not found !");
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee)
    {
        newEmployee.setId(0);
        return employeeService.save(newEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee newEmployee)
    {
        return employeeService.save(newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee delEmployee = employeeService.findByID(id);
        if(delEmployee == null)
        throw new RuntimeException("Employee with Id "+id+" doesn't exist!");
        employeeService.delete(id);
        return "Employee with id "+ id +" deleted!" ;
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id,@RequestBody Map<String,Object> patchPayload)
    {
        Employee theEmployee = employeeService.findByID(id);
        if(theEmployee == null)
        throw new RuntimeException("Employee with id "+ id + " not found!");

        if(patchPayload.containsKey("id"))
        throw new RuntimeException("Employee id not allowed in request body - " + id);

        Employee patchedEmployee = apply(patchPayload,theEmployee);
        
        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String,Object>patchPayload, Employee theEmployee) {

        //Convert employee object to a JSON object node
        ObjectNode empNode = objectMapper.convertValue(theEmployee,ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        // Merge the patch updates into the employee node
        empNode.setAll(patchNode);
 
        return objectMapper.convertValue(empNode, Employee.class);
    }
}
