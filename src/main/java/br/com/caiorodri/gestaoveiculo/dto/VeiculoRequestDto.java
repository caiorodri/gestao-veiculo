package br.com.caiorodri.gestaoveiculo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record VeiculoRequestDto(
        @NotBlank String marcaFipeCodigo,
        @NotBlank String modeloFipeCodigo,
        @NotBlank String anoFipeCodigo,
        @NotBlank String apelido,
        @NotNull BigDecimal valorCompra,
        @NotNull LocalDate dataCompra
) {}