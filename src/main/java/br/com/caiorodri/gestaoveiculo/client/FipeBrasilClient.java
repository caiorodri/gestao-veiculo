package br.com.caiorodri.gestaoveiculo.client;

import br.com.caiorodri.gestaoveiculo.config.FeignConfig;
import br.com.caiorodri.gestaoveiculo.dto.MarcaDto;
import br.com.caiorodri.gestaoveiculo.dto.feign.BrasilApiFipeDto;
import br.com.caiorodri.gestaoveiculo.dto.feign.BrasilApiReferenciaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "fipeClient", url = "${fipe.url}", configuration = FeignConfig.class)
public interface FipeClient {

    @GetMapping("/tabelas/v1")
    List<BrasilApiReferenciaDto> listarReferencias();

    @GetMapping("/preco/v1/{codigoFipe}")
    List<BrasilApiFipeDto> buscarPrecoAtual(@PathVariable("codigoFipe") String codigoFipe);

    @GetMapping("/preco/v1/{codigoFipe}")
    List<BrasilApiFipeDto> buscarPrecoHistorico(
            @PathVariable("codigoFipe") String codigoFipe,
            @RequestParam("tabela_referencia") Integer tabelaReferencia
    );

    @GetMapping("/marcas/v1/carros")
    List<MarcaDto> buscarMarcas();

}