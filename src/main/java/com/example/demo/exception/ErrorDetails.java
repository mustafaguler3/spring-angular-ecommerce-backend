package com.example.demo.exception;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ErrorDetails {

    private String timestamp;
    private int statusCode;
    private String message;
    private String path;
    private String trace;


}




















