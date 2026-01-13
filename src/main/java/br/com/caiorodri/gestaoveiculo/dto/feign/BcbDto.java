package br.com.caiorodri.gestaoveiculo.dto.feign;

import com.fasterxml.jackson.annotation.JsonAlias;

public record BcbDto(
        @JsonAlias("data") String data,
        @JsonAlias("valor") String valor
) {}