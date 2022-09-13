package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:3000")
public class StudentController {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Tom", "US"),
                    new Student(2, "Harry", "Canada"),
                    new Student(3, "Nick", "UK")
            )
    );

    // Mappings - URL endpoints
    // Get the list of all student
    @GetMapping
    public String displayWelcomeMessage(){
        return "<center><h1>Welcome to the Spring Boot Security!!!!</h1></center>";
    }
    @GetMapping("/listStudents")
    public List<Student> getAllStudents(){
        return students;
    }
    // Get the student information
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id){
        for(int i=0; i< students.size(); i++){
            if(students.get(i).getId()==id){
                return students.get(i);
            }
        }
        return null;
    }
    // Delete the student
    @DeleteMapping("/student/{id}")
    public List<Student> deleteStudent(@PathVariable Integer id){
        for(int i=0; i< students.size(); i++){
            if(students.get(i).getId()==id){
                students.remove(i);
            }
        }
        return students;
    }
    // Add new student
    @PostMapping("/student")
    public List<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return students;
    }
    // Update the student information
    @PutMapping("/student/{id}")
    public List<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id){
        for(int i=0; i< students.size(); i++){
            if(students.get(i).getId()==id){
                students.get(i).setName(student.getName());
                students.get(i).setAddress(student.getAddress());
            }
        }
        return students;
    }

}