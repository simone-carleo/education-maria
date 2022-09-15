package it.adt.mvntestproject.rest.config;

import it.adt.mvntestproject.common.exception.*;
import it.adt.mvntestproject.common.utils.ResponseUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseUtil.getBadRequestErrorResponse(ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseUtil.getBadRequestErrorResponse(ex);
    }

    @ExceptionHandler(value = { //
            FieldNotValidException.class, //
            ConstraintViolationException.class, //
            org.hibernate.exception.ConstraintViolationException.class, //
            EntityAlreadyExistsException.class, //
            EntityAlreadyExistsRuntimeException.class//
    })
    public final ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return ResponseUtil.getBadRequestErrorResponse(ex);
    }

    @ExceptionHandler(value = { //
            EntityNotFoundException.class, //
            EntityNotFoundRuntimeException.class//
    })
    public final ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return ResponseUtil.getNotFoundErrorResponse(ex);
    }

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> defaultExceptionHandler(Exception ex) {
        return ResponseUtil.getInternalServerErrorResponse(ex);
    }
}