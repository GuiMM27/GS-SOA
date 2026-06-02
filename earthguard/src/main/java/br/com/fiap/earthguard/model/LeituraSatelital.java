package br.com.fiap.earthguard.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class LeituraSatelital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;
    private Double umidade;
    private LocalDateTime dataHoraRegistro;

    @ManyToOne
    @JoinColumn(name = "satelite_id")
    private Satelite satelite;
}