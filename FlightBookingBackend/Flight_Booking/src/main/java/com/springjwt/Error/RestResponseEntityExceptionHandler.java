package com.springjwt.Error;


import com.springjwt.entities.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception,
                                                              WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<ErrorMessage> userFoundException(UserFoundException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorMessage> userFoundException(FlightNotFoundException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(DuplicateFlightFoundException.class)
    public ResponseEntity<ErrorMessage> userFoundException(DuplicateFlightFoundException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(DuplicateBookingIdFoundException.class)
    public ResponseEntity<ErrorMessage> userFoundException(DuplicateBookingIdFoundException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(BookingIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> userFoundException(BookingIdNotFoundException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMessage> badCredentialsException(BadCredentialsException exception,
                                                           WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }

    @ExceptionHandler(JWTInvalidException.class)
    public ResponseEntity<ErrorMessage> jwtInvalidException(JWTInvalidException exception,
                                                                WebRequest request){

        ErrorMessage message = new ErrorMessage(exception.getMessage(),
                404,false);

        return ResponseEntity.status(message.getStatus()).body(message);

    }


}
