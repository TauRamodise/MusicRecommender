package com.music.musicrec.exceptions;

public class MappingException extends Exception {
    Throwable cause;
    public MappingException(String message) {
        super(message);
    }

    public MappingException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

}
