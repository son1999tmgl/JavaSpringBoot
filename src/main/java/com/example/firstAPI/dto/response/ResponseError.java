package com.example.firstAPI.dto.response;

public class ResponseError<T> extends ResponData{
    public ResponseError(int status, String message) {
        super(status, message);
    }

    public ResponseError(int status, String message, T data) {
        super(status, message, data);
    }
}
