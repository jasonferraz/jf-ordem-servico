package com.jasonferraz.jason_ferraz_os.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String equipamento;
    private String defeito;
    private BigDecimal orcamento;
    private String status;

    private LocalDateTime dataEntrada;

    @PrePersist
    protected void onCreate() {
        this.dataEntrada = LocalDateTime.now();
    }
}