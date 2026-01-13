package br.com.caiorodri.gestaoveiculo.dto.feign;

import br.com.caiorodri.gestaoveiculo.dto.MarcaDto;

import java.util.List;

public record FipeModeloCollectionDto(
        List<MarcaDto> modelos,
        List<MarcaDto> anos
) {}