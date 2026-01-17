package br.com.caiorodri.gestaoveiculo.dto.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MarcaBrasilDto(
        @JsonProperty("nome") String codigo,
        @JsonProperty("valor") String nome
) {
}
