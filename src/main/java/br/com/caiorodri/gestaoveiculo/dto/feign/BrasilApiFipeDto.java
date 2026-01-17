package br.com.caiorodri.gestaoveiculo.dto.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BrasilApiFipeDto(
        @JsonProperty("valor") String valor,
        @JsonProperty("marca") String marca,
        @JsonProperty("modelo") String modelo,
        @JsonProperty("anoModelo") Integer anoModelo,
        @JsonProperty("combustivel") String combustivel,
        @JsonProperty("codigoFipe") String codigoFipe,
        @JsonProperty("mesReferencia") String mesReferencia,
        @JsonProperty("tipoVeiculo") Integer tipoVeiculo,
        @JsonProperty("siglaCombustivel") String siglaCombustivel,
        @JsonProperty("dataConsulta") String dataConsulta
) {}