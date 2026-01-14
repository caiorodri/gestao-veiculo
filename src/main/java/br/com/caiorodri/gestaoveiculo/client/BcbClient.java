package br.com.caiorodri.gestaoveiculo.client;

import br.com.caiorodri.gestaoveiculo.config.FeignConfig;
import br.com.caiorodri.gestaoveiculo.dto.feign.BcbDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "bcbClient", url = "${bcb.url}", configuration = FeignConfig.class)
public interface BcbClient {

    @GetMapping("/dados/serie/bcdata.sgs.{codigo}/dados")
    List<BcbDto> buscarUltimoIndice(@PathVariable("codigo") Integer codigo, @RequestParam("ultimo") Integer ultimo);

    @GetMapping("/dados/serie/bcdata.sgs.{codigo}/dados")
    List<BcbDto> buscarPorPeriodo(
            @PathVariable("codigo") Integer codigo,
            @RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal
    );
}