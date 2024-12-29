package com.example.firstAPI.dto.response;

import org.springframework.http.HttpStatusCode;

public class ResponseFailure extends ResponseSuccess{

    public ResponseFailure(Object data, HttpStatusCode status) {
        super(data, status);
    }

    public ResponseFailure(HttpStatusCode status, String message) {
        super(status);
    }
}
