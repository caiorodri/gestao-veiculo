package br.com.caiorodri.gestaoveiculo.dto;

import br.com.caiorodri.gestaoveiculo.dto.feign.FipeDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VeiculoResponseDto(
        Long id,
        FipeDto marca,
        ModeloDto modelo,
        FipeDto ano,
        String apelido,
        BigDecimal valorAtualFipe,
        BigDecimal valorCompra,
        LocalDate dataCompra
) {}