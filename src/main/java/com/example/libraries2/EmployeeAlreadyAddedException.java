package com.example.libraries2;

public class EmployeeAlreadyAddedException extends RuntimeException {

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}

