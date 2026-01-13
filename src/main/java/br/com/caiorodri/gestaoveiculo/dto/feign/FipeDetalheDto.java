package br.com.caiorodri.gestaoveiculo.dto.feign;

import com.fasterxml.jackson.annotation.JsonAlias;

public record FipeDetalheDto(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("CodigoFipe") String codigoFipe
) {}