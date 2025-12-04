package com.saasbeauty.systemservice.infrastructure.config.exception;

import com.saasbeauty.systemservice.domain.exceptions.BusinessException;
import com.saasbeauty.systemservice.domain.exceptions.ResourceNotFoundException;
// Importa tu ApiResponse si la tienes en otro paquete
// import com.saasbeauty.common.dto.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Manejo de Recurso No Encontrado (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    // 2. Manejo de Reglas de Negocio (400)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusiness(BusinessException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), null);
    }

    // 3. Manejo de Validaciones @Valid (400 con detalles)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return buildResponse(HttpStatus.BAD_REQUEST, "Error de validación en los campos", errors);
    }

    // 4. Manejo Genérico (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        ex.printStackTrace(); // Importante para ver el error en logs
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error interno inesperado", ex.getMessage());
    }

    // Método Helper para construir el JSON estándar
    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, Object data) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        body.put("message", message);
        body.put("data", data);
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        return new ResponseEntity<>(body, status);
    }
}