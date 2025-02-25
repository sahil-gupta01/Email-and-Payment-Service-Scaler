package com.foodOrderingApp.app.exceptionHandler;

import com.foodOrderingApp.app.dtos.ErrorResponseDto;
import com.foodOrderingApp.app.exceptions.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidId(){
        return new ResponseEntity<>(new ErrorResponseDto("Invalid user id"), HttpStatus.NOT_FOUND);

    }
}
