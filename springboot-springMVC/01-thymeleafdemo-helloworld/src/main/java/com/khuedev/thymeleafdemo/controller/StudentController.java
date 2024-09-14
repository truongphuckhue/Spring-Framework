package com.khuedev.thymeleafdemo.controller;

import com.khuedev.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${favoriteLanguages}")
    private List<String> favoriteLanguages;

    @Value("${favoriteSystems}")
    private List<String> favoriteSystems;
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("favoriteLanguages" , favoriteLanguages);
        model.addAttribute("favoriteSystems", favoriteSystems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
