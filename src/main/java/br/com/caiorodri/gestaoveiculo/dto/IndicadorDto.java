package br.com.caiorodri.gestaoveiculo.dto;

import java.math.BigDecimal;

public record IndicadorDto(
        String mesReferencia,
        BigDecimal ipca,
        BigDecimal cdi
) {}