package br.com.caiorodri.gestaoveiculo.client;

import br.com.caiorodri.gestaoveiculo.config.FeignConfig;
import br.com.caiorodri.gestaoveiculo.dto.feign.FipeDetalheDto;
import br.com.caiorodri.gestaoveiculo.dto.feign.FipeModeloCollectionDto;
import br.com.caiorodri.gestaoveiculo.dto.MarcaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipeClient", url = "${fipe.url}", configuration = FeignConfig.class)
public interface FipeClient {

    @GetMapping("/carros/marcas")
    List<MarcaDto> buscarMarcas();

    @GetMapping("/carros/marcas/{marca}/modelos")
    FipeModeloCollectionDto listarModelos(@PathVariable("marca") String marca);

    @GetMapping("/carros/marcas/{marca}/modelos/{modelo}/anos")
    List<MarcaDto> listarAnos(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo);

    @GetMapping("/carros/marcas/{marca}/modelos/{modelo}/anos/{ano}")
    FipeDetalheDto buscarDetalheCarro(@PathVariable("marca") String marca,
                                      @PathVariable("modelo") String modelo,
                                      @PathVariable("ano") String ano);

}