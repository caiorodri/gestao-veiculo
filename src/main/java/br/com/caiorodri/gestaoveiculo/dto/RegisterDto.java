package br.com.caiorodri.gestaoveiculo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDto(
        @NotBlank String nome,
        @NotBlank @Email(message = "E-mail inválido!") String email,
        @NotBlank @Size(min = 8, message = "Senha deve conter no minimo 8 caracteres!") String senha
) {}