package com.cdac.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.cdac.dao.StudentDAO;
import com.cdac.model.Student;

@Controller
public class StudentController {
	
	private StudentDAO studentDAO;

    public void setStudentDAO(
            StudentDAO studentDAO) {

        this.studentDAO = studentDAO;
    }

    @GetMapping("/register")
    public String showForm() {

        return "register";
    }

    @PostMapping("/save")
    public String saveStudent(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String course,
            Model model) {

        Student student =
                new Student(id, name, course);

        studentDAO.save(student);

        model.addAttribute(
                "msg",
                "Student Registered Successfully");

        return "success";
    }

    @GetMapping("/view")
    public String viewStudents(
            Model model) {

        List<Student> students =
                studentDAO.getAllStudents();

        model.addAttribute(
                "students",
                students);

        return "viewstudents";
    }


}
