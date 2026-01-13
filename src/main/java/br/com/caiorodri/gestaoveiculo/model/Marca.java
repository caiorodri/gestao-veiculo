package br.com.caiorodri.gestaoveiculo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_fipe", unique = true, nullable = false)
    private String codigoFipe;

    @Column(nullable = false)
    private String nome;
}