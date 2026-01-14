package br.com.caiorodri.gestaoveiculo.repository;

import br.com.caiorodri.gestaoveiculo.model.Usuario;
import br.com.caiorodri.gestaoveiculo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByUsuario(Usuario usuario);

}
