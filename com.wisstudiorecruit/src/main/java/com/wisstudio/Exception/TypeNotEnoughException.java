package com.wisstudio.Exception;

public class TypeNotEnoughException extends RuntimeException {
    public TypeNotEnoughException() {
    }

    public TypeNotEnoughException(String message) {
        super(message);
    }

    public TypeNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeNotEnoughException(Throwable cause) {
        super(cause);
    }

    public TypeNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
