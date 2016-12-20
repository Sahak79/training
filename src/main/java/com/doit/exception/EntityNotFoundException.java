package com.doit.exception;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public class EntityNotFoundException extends Exception{

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
