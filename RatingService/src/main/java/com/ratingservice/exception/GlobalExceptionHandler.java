package com.ratingservice.exception;

import com.ratingservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String s = ex.getMessage();
        ApiResponse build = ApiResponse.builder().message(s).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);


    }
}
