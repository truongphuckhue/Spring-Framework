package com.khuedev.demo.rest;

import com.khuedev.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> list;
    @PostConstruct
    private void loadData(){
        list = new ArrayList<>();
        list.add(new Student("Khue" , "Truong"));
        list.add(new Student("Khue" , "Nguyen"));
        list.add(new Student("Khue" , "Bui"));
        list.add(new Student("Khue" , "Ngo"));
    }
    @GetMapping("/students")
    public List<Student> listStudent(){
        return list;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId < 0 || studentId >= list.size()){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return list.get(studentId);
    }
    /*@ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(StudentNotFoundException exc){
        StudentErrorRespone studentErrorRespone = new StudentErrorRespone();
        studentErrorRespone.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorRespone.setMessage(exc.getMessage());
        studentErrorRespone.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorRespone, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(Exception studentNotFoundException){
        StudentErrorRespone studentErrorRespone = new StudentErrorRespone();
        studentErrorRespone.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorRespone.setMessage(studentNotFoundException.getMessage());
        studentErrorRespone.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorRespone, HttpStatus.BAD_REQUEST);
    }*/
}
