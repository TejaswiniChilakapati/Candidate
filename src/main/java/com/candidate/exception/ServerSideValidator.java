package com.candidate.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServerSideValidator extends ResponseEntityExceptionHandler {
    private static final Logger validatorLogger = LoggerFactory.getLogger(ServerSideValidator.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exp,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        validatorLogger.info("\n\n =====>>  Inside ServerSideInsuranceValidator ");
        Map<String, String> errorMap = new HashMap<>();

        List<ObjectError> errorList = exp.getBindingResult().getAllErrors();

        errorList.forEach(e -> {
            String propertyName = ((FieldError) e).getField();
            String errorMsg = e.getDefaultMessage();

            errorMap.put(propertyName, errorMsg);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}

