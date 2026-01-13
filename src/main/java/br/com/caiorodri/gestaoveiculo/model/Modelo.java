package br.com.caiorodri.gestaoveiculo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @Column(name = "codigo_api")
    private String codigoApi;

    @Column(name = "codigo_fipe", nullable = false)
    private String codigoFipe;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer ano;

    private String combustivel;

    @Column(name = "valor_atual")
    private BigDecimal valorAtual;
}