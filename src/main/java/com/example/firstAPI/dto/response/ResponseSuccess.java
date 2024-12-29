package com.example.firstAPI.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseSuccess extends ResponseEntity {
    public ResponseSuccess(HttpStatusCode status) {
        super(status);
    }

    public ResponseSuccess(HttpStatusCode status, String message) {
        super(new Payload(message, status.value()), HttpStatus.OK);
    }
    public ResponseSuccess(HttpStatusCode status, String message, Object data) {
        super(new Payload(message, status.value(), data), HttpStatus.OK);
    }
    public ResponseSuccess(Object data, HttpStatusCode status) {
        super(data, status);
    }


    public ResponseSuccess(MultiValueMap headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ResponseSuccess(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public ResponseSuccess(Object body, MultiValueMap headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }

    public static class Payload {
        private final int status;
        private final String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object data;

        public Payload(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public Payload(String message,  int status, Object data) {
            this.message = message;
            this.data = data;
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public Object getData() {
            return data;
        }

        public String getMessage() {
            return message;
        }
    }
}
