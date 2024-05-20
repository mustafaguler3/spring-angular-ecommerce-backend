package com.example.demo.exception;

import com.example.demo.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errors = bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setErrors(errors);

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){

        String path = request.getDescription(false);//url path
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setTimestamp(LocalDateTime.now().toString());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTrace(ex.getLocalizedMessage().toString());
        errorDetails.setPath(path);

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
}





















