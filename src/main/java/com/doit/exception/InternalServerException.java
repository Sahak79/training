package com.doit.exception;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public class InternalServerException extends RuntimeException {

    public InternalServerException(){}

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }
}
