package br.com.caiorodri.gestaoveiculo.dto;

import java.math.BigDecimal;

public record VeiculoResponseDto(
        Long id,
        String marca,
        String modelo,
        Integer ano,
        String apelido,
        BigDecimal valorAtualFipe
) {}