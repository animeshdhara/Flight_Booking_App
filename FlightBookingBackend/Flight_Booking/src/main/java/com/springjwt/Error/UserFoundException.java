package com.springjwt.Error;

public class UserFoundException extends Exception{
    public UserFoundException(){
        super();
    }
    public UserFoundException(String message){
        super(message);
    }
    public UserFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public UserFoundException(Throwable cause){
        super(cause);
    }

    public UserFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

