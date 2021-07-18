package com.assessment.damco.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleServerError(AppException ex) {
        log.debug("App Exception {} ;", ex.getMessage());
        return new  ResponseEntity<>(ex.getMessage(),ex.getHttpStatus());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleBindError(MethodArgumentNotValidException ex) {
        return new  ResponseEntity<>(buildBadRequestMsg(ex.getBindingResult()), HttpStatus.BAD_REQUEST);
    }


    private Object buildBadRequestMsg(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errorViolations = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errorViolations.add(fieldError.getDefaultMessage());
        }
        return errorViolations;
    }





}
