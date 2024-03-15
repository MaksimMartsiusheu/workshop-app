package edu.epam.worckshop.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationServiceException extends RuntimeException {

    private final HttpStatus status;

    public ApplicationServiceException(HttpStatus status) {
        this.status = status;
    }

    public ApplicationServiceException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }

    public ApplicationServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ApplicationServiceException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }
}
