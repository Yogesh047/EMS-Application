package com.wishfy.EMS.ExceptionHandling;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Employee not found with ID: " + id);
    }
}
