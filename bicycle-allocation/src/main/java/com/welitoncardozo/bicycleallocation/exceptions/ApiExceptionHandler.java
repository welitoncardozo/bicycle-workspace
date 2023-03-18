package com.welitoncardozo.bicycleallocation.exceptions;

import com.welitoncardozo.bicycleallocation.exceptions.dto.FieldExceptionHandler;
import com.welitoncardozo.bicycleallocation.exceptions.dto.MessageExceptionHandler;
import com.welitoncardozo.bicycleallocation.translates.TranslateMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                final List<FieldExceptionHandler> fieldsException = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .map(fieldError -> FieldExceptionHandler.builder()
                        .name(fieldError.getField())
                        .message(TranslateMessage.getMessage(fieldError))
                        .build())
                .collect(toList());

        final MessageExceptionHandler messageExceptionHandler = MessageExceptionHandler.builder()
                .statusCode(status.value())
                .title("Campos inválidos, faça o preenchimento correto e tente novamente.")
                .fields(fieldsException)
                .occurrenceDate(LocalDateTime.now())
                .build();
        return super.handleExceptionInternal(ex, messageExceptionHandler, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(final BusinessException ex, final WebRequest request) {
        final MessageExceptionHandler messageExceptionHandler = MessageExceptionHandler.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title(ex.getMessage())
                .occurrenceDate(LocalDateTime.now())
                .build();

        return super.handleExceptionInternal(ex, messageExceptionHandler, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(final EntityNotFoundException ex, final WebRequest request) {
        final MessageExceptionHandler messageExceptionHandler = MessageExceptionHandler.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .title(ex.getMessage())
                .occurrenceDate(LocalDateTime.now())
                .build();

        return super.handleExceptionInternal(ex, messageExceptionHandler, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
