package br.com.caiorodri.gestaoveiculo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "indicador")
public class Indicador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_referencia", nullable = false, unique = true)
    private LocalDate dataReferencia;

    private BigDecimal ipca;

    private BigDecimal cdi;
}