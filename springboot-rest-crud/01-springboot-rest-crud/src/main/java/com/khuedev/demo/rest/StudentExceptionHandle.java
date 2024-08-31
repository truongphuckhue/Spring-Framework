package com.khuedev.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandle {
    @ExceptionHandler
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
    }
}
