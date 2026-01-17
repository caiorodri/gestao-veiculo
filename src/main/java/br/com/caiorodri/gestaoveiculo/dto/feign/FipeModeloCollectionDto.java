package br.com.caiorodri.gestaoveiculo.dto.feign;

import java.util.List;

public record FipeModeloCollectionDto(
        List<FipeDto> modelos,
        List<FipeDto> anos
) {}