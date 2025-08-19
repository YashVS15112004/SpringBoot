package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    // need a controller method to show initial HTML form.
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }
    // Need a controller method to process the HTML form.
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }
    // need a controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request,Model model)
    {
        // read the request param from HTMLForm
        String theName = request.getParameter("studentName");
        //COnvert the data to all caps
        theName = theName.toUpperCase();
        // create the msg
        String result = "Yo " + theName + "!";
        // add msg to model
        model.addAttribute("message",result);
        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree (@RequestParam("studentName") String theName,Model model)
    {
        //COnvert the data to all caps
        theName = theName.toUpperCase();
        // create the msg
        String result = "Hello " + theName + "!";
        // add msg to model
        model.addAttribute("message",result);
        return "helloworld";
    }
}
