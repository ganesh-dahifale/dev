package com.emp.management.empmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyPresentException extends RuntimeException{
    public EmployeeAlreadyPresentException(String message){
        super(message);
    }
}
