package br.com.caiorodri.gestaoveiculo.dto;

import br.com.caiorodri.gestaoveiculo.dto.feign.FipeDto;

import java.math.BigDecimal;

public record HistoricoDto(
        Long id,
        FipeDto modelo,
        String dataReferencia,
        BigDecimal valor
) {}