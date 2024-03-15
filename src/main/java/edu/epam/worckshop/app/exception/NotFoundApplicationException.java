package edu.epam.worckshop.app.exception;

import org.springframework.http.HttpStatus;

public class NotFoundApplicationException extends ApplicationServiceException {

    public NotFoundApplicationException() {
        super(HttpStatus.NOT_FOUND);
    }

    public NotFoundApplicationException(Throwable cause) {
        super(cause, HttpStatus.NOT_FOUND);
    }

    public NotFoundApplicationException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoundApplicationException(String message, Throwable cause) {
        super(message, cause, HttpStatus.NOT_FOUND);
    }
}
