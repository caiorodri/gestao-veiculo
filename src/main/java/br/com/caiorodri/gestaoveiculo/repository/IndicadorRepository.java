package br.com.caiorodri.gestaoveiculo.repository;

import br.com.caiorodri.gestaoveiculo.model.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Long> {

    Optional<Indicador> findByDataReferencia(LocalDate dataReferencia);
}