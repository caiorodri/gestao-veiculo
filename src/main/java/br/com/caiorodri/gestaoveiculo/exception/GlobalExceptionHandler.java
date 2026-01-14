package br.com.caiorodri.gestaoveiculo.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String errorMessages = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return montarResposta(HttpStatus.BAD_REQUEST, "Erro de validação", errorMessages, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        return montarResposta(HttpStatus.NOT_FOUND, "Recurso não encontrado", e.getMessage(), request);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<StandardError> badCredentials(BadCredentialsException e, HttpServletRequest request) {
        return montarResposta(HttpStatus.UNAUTHORIZED, "Falha na autenticação", "Email ou senha inválidos", request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityViolationException e, HttpServletRequest request) {
        String mensagem = "Violação de integridade de dados";

        if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
            mensagem = "Este registro (email ou código) já existe no sistema";
        }
        return montarResposta(HttpStatus.CONFLICT, "Erro de Integridade", mensagem, request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> jsonErrorException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return montarResposta(HttpStatus.BAD_REQUEST, "Requisição mal formada", "Erro na leitura do JSON enviado", request);
    }

    @ExceptionHandler({TokenExpiredException.class, JWTVerificationException.class})
    public ResponseEntity<StandardError> tokenErrorException(Exception e, HttpServletRequest request) {
        return montarResposta(HttpStatus.FORBIDDEN, "Token inválido", e.getMessage(), request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> accessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        return montarResposta(HttpStatus.FORBIDDEN, "Acesso negado", "Você não tem permissão para acessar este recurso", request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> databaseException(Exception e, HttpServletRequest request) {
        logger.error("Erro interno do servidor: {}", e.getMessage());
        return montarResposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", e.getMessage(), request);
    }

    private ResponseEntity<StandardError> montarResposta(HttpStatus status, String error, String message, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(message);
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}