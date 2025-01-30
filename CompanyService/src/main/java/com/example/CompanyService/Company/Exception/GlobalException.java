package com.example.CompanyService.Company.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFound(ResourceNotFound resourceNotFound)
    {
        ExceptionResponse  exceptionResponse=
                new ExceptionResponse(
                      LocalDateTime.now(),
                       HttpStatus.NOT_FOUND.value(),
                    "Not Found",
                    resourceNotFound.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public  ResponseEntity<ExceptionResponse> handleInvalidInputException(InvalidInputException ex)
    {
        ExceptionResponse response= new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Input Exception",
                ex.getMessage()
        );
        return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public  ResponseEntity<String> handleGeneralException(Exception ex)
    {
        return  new ResponseEntity<>("An other exception is occurred "+ ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
