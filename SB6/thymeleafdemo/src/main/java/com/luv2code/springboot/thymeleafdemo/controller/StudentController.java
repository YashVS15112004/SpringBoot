package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel)
    {
        // create a student object
        Student theStudent = new Student();

        // Add student object to model
        theModel.addAttribute("student",theStudent);
        // Add countries to model
        theModel.addAttribute("countries",countries);
        // Add languages to model
        theModel.addAttribute("languages",languages);
        // Add systems to model
        theModel.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println("The Student : "+theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
