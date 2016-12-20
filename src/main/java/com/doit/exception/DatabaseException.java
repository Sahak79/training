package com.doit.exception;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public class DatabaseException extends Exception {
    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
