package com.springjwt.Error;

public class DuplicateFlightFoundException extends Exception{
    public DuplicateFlightFoundException(){
        super();
    }
    public DuplicateFlightFoundException(String message){
        super(message);
    }
    public DuplicateFlightFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public DuplicateFlightFoundException(Throwable cause){
        super(cause);
    }

    public DuplicateFlightFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}