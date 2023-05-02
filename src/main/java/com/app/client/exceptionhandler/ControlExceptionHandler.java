package com.app.client.exceptionhandler;

import com.app.client.exception.AddressNotFound;
import feign.Feign;
import feign.FeignException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControlExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail ConstraintViolationExceptionHandle(ConstraintViolationException exception) {
        final ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setType(URI.create("https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status/400"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setDetail(exception.getConstraintViolations().toString());
        return problemDetail;
    }

    @ExceptionHandler(AddressNotFound.class)
    public ProblemDetail ConstraintViolationExceptionHandle(AddressNotFound exception) {
        final ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setType(URI.create("https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status/404"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }


}
