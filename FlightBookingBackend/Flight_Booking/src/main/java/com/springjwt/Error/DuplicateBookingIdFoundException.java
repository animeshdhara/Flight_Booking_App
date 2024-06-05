package com.springjwt.Error;
public class DuplicateBookingIdFoundException extends Exception{
    public DuplicateBookingIdFoundException(){
        super();
    }
    public DuplicateBookingIdFoundException(String message){
        super(message);
    }
    public DuplicateBookingIdFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public DuplicateBookingIdFoundException(Throwable cause){
        super(cause);
    }

    public DuplicateBookingIdFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
