package br.com.fiap.earthguard.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class EquipamentoEspacial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataLancamento;
    private boolean statusOperacional;
}