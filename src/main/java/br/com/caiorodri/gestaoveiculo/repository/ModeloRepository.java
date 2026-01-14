package br.com.caiorodri.gestaoveiculo.repository;

import br.com.caiorodri.gestaoveiculo.model.Marca;
import br.com.caiorodri.gestaoveiculo.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    Optional<Modelo> findByCodigoFipeAndAno(String codigoFipe, Integer ano);

    Optional<Modelo> findByCodigoApiAndAno(String codigoApi, Integer ano);

    List<Modelo> findByMarca(Marca marca);

}
