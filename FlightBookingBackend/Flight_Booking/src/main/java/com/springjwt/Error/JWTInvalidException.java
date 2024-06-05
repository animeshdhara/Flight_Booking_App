package com.springjwt.Error;

public class JWTInvalidException extends Exception{
    public JWTInvalidException(){
        super();
    }
    public JWTInvalidException(String message){
        super(message);
    }
    public JWTInvalidException(String message,Throwable cause){
        super(message,cause);
    }
    public JWTInvalidException(Throwable cause){
        super(cause);
    }

    public JWTInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
