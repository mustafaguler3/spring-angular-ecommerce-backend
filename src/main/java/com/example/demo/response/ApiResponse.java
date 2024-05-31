package com.example.demo.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse <T>{

    private HttpStatus statusCode;
    private String message;
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ApiResponse(HttpStatus statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public ApiResponse(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = (message != null) ? message : getMessageForStatusCode(statusCode);;
    }

    public ApiResponse(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = (message != null) ? message : getMessageForStatusCode(statusCode);
        this.data = data;
    }

    private String getMessageForStatusCode(HttpStatus statusCode){
        switch (statusCode) {
            case OK:
                return "Success Data";
            case BAD_REQUEST:
                return "A bad request, you have made";
            case UNAUTHORIZED:
                return "Authorized, you are not";
            case NOT_FOUND:
                return "Recourse not found access you want";
            case INTERNAL_SERVER_ERROR:
                return "Errors are the path to the dark side";
            default:
                return "Unknown status code";
        }
    }
}























