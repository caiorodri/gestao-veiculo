package br.com.caiorodri.gestaoveiculo.security;

import br.com.caiorodri.gestaoveiculo.exception.StandardError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper mapper;

    public CustomAuthenticationEntryPoint(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setError("Acesso Negado");
        error.setMessage("Token ausente, inválido ou expirado");
        error.setPath(request.getRequestURI());

        String jsonOutput = mapper.writeValueAsString(error);

        response.getWriter().write(jsonOutput);
    }
}