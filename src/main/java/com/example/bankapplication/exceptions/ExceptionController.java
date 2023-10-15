package com.example.bankapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoEnoughAmount.class)
    public ResponseEntity<ErrorDetails> handleNoEnoughAmount(NoEnoughAmount ex) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(),"500");
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AccountNotExist.class)
    public ResponseEntity<ErrorDetails> handleAccountNotExist(AccountNotExist ex) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(),"500");
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
