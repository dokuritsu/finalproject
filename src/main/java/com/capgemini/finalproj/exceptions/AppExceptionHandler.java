package com.capgemini.finalproj.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler{
    @ResponseBody
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFoundException(EmployeeNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ExistingEmployeeException.class)
    public ResponseEntity<?> exisitingEmployeeException(ExistingEmployeeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ProjectNotFoundException.class)
    public ResponseEntity<?> projectNotFoundException(ProjectNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ExistingProjectException.class)
    public ResponseEntity<?> exisitingProjectException(ExistingProjectException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = DeptNotFoundException.class)
    public ResponseEntity<?> deptNotFoundException(DeptNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ExistingDeptException.class)
    public ResponseEntity<?> exisitingDeptException(ExistingDeptException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}