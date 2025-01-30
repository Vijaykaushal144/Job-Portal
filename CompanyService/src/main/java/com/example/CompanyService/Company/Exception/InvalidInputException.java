package com.example.CompanyService.Company.Exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message)
    {
        super(message);
    }
}

