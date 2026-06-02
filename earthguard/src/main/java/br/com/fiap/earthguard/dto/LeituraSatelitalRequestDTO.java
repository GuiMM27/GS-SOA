package br.com.fiap.earthguard.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public record LeituraSatelitalRequestDTO(
        @NotNull(message = "A temperatura é obrigatória")
        Double temperatura,

        @NotNull(message = "A umidade é obrigatória")
        Double umidade,

        @NotNull(message = "A data e hora são obrigatórias")
        @PastOrPresent(message = "A data da leitura não pode estar no futuro")
        LocalDateTime dataHoraRegistro,

        @NotNull(message = "O ID do satélite que fez a leitura é obrigatório")
        Long sateliteId
) {}