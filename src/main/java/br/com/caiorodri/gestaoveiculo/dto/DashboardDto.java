package br.com.caiorodri.gestaoveiculo.dto;

import java.math.BigDecimal;

public record DashboardDto(
        BigDecimal totalValorCompra,
        BigDecimal totalValorAtual,
        BigDecimal variacaoTotal,
        Integer quantidadeVeiculos
) {}