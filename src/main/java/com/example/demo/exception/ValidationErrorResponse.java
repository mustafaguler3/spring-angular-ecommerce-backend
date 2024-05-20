package com.example.demo.exception;

import com.example.demo.response.ApiResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ValidationErrorResponse extends ApiResponse {

    private List<String> errors;

    public ValidationErrorResponse() {
        super(HttpStatus.BAD_REQUEST,null);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
