package com.microservicio.microservicio_imagen.infrastructure.controllers;

import com.microservicio.microservicio_imagen.application.exceptions.*;
import com.microservicio.microservicio_imagen.infrastructure.converters.dto.ErrorResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> NotFoundExceptionHandler(NotFoundException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).
                message("Err-001: No se ha encontrado el registro").timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> NoSuchElementExceptionHandler(NoSuchElementException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-(002/003): El elemento a modificar no existe").timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<ErrorResponse> ClientErrorExceptionHandler(ClientErrorException ex) {
        ErrorResponse response = ErrorResponse.builder().status(ex.getStatus()).
                message(ex.getMessage()).timestamp(new Date()).build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ErrorResponse> ServerErrorExceptionHandler(ServerErrorException ex) {
        ErrorResponse response = ErrorResponse.builder().status(ex.getStatus()).
                message(ex.getMessage()).timestamp(new Date()).build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> InvalidDataExceptionHandler(InvalidDataException ex) {
        List<String> errors = ex.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-007: Uno o más datos no fueron llenados correctamente").errors(errors)
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> NoDataFoundExceptionHandler(NoDataFoundException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-014: Los datos requeridos no fueron introducidos correctamente")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoChangeDetectedException.class)
    public ResponseEntity<ErrorResponse> NoChangeDetectedExceptionHandler(NoChangeDetectedException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.CONFLICT.value()).
                message("Err-015: Los datos introducidos ya se encuentran registrados")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorResponse> DuplicateKeyExceptionHandler(DuplicateKeyException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.CONFLICT.value()).
                message("Err-004: Ya existe un registro con el id seleccionado").timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> IllegalArgumentExceptionHandler(IllegalArgumentException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-005: Los parámetros pasados no son válidos")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<ErrorResponse> MissingServletRequestPartExceptionHandler(MissingServletRequestPartException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-016: La imagen requerida no ha sido subida o no se encuentra")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> MissingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-017: El parametro de la url requerido no fue encontrado")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> IOExceptionHandler(IOException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).
                message("Err-006: La imagen no pudo ser procesada correctamente")
                .timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> ExceptionHandler(Exception ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                message("Err-008: Hubo un problema inesperado en el sistema").timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> RuntimeExceptionHandler(RuntimeException ex) {
        ErrorResponse response = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                message("Err-009: Hubo un problema inesperado en el sistema").timestamp(new Date()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}