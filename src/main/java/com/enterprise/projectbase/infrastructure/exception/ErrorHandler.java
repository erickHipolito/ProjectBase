package com.enterprise.projectbase.infrastructure.exception;

import com.enterprise.projectbase.infrastructure.exception.custom.JWTUnAuthorizedTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorMessage> handleAnyException(Exception ex) {
        log.error("[ErrorHandler:AnyException] " + ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .errorCode(EEnumException.RSE_INTERNAL_SERVER_ERROR.errorCode)
                        .errorDescription(ex.getMessage())
                        .timestamp(new Date())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({JWTUnAuthorizedTokenException.class})
    public ResponseEntity<ErrorMessage> handleInvalidTokenException(EAbstractException ex) {
        log.error("[ErrorHandler:handleInvalidTokenException] " + ex.getErrorDescription());
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .errorCode(ex.getErrorCode())
                        .errorDescription(ex.getErrorDescription())
                        .timestamp(new Date())
                        .build(), HttpStatus.UNAUTHORIZED);
    }


    @NonNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final BindingResult bindingResult = ex.getBindingResult();
        List<ErrorMessage> errorList = new ArrayList<>(1);
        if (bindingResult.hasErrors()) {
            final List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                String field = fieldError.getField();
                errorList.add(ErrorMessage.builder().errorDescription(field + ": " + fieldError.getDefaultMessage())
                        .errorCode(EEnumException.PARAMETER_NOT_VALID_ERROR.errorCode)
                        .errorDescription(EEnumException.PARAMETER_NOT_VALID_ERROR.errorDescription)
                        .timestamp(new Date())
                        .build());
            }
        }
        return new ResponseEntity<>(errorList, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ErrorMessage error = ErrorMessage.builder().errorCode(EEnumException.PARAMETER_NOT_VALID_ERROR.errorCode)
                .errorDescription(ex.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
