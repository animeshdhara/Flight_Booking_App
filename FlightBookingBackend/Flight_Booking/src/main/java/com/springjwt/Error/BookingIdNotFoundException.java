package com.springjwt.Error;

public class BookingIdNotFoundException extends Exception{
    public BookingIdNotFoundException(){
        super();
    }
    public BookingIdNotFoundException(String message){
        super(message);
    }
    public BookingIdNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public BookingIdNotFoundException(Throwable cause){
        super(cause);
    }

    public BookingIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
