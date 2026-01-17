package br.com.caiorodri.gestaoveiculo.dto.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BrasilApiReferenciaDto(
        @JsonProperty("codigo") Integer codigo,
        @JsonProperty("mes") String mes
) {}