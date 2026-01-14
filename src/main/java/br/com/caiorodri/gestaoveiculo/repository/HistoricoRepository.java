package br.com.caiorodri.gestaoveiculo.repository;

import br.com.caiorodri.gestaoveiculo.model.Historico;
import br.com.caiorodri.gestaoveiculo.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByModeloOrderByDataReferenciaAsc(Modelo modelo);

    Optional<Historico> findByModeloAndDataReferencia(Modelo modelo, LocalDate dataReferencia);

}
