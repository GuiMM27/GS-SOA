package br.com.fiap.earthguard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record SateliteRequestDTO(
        @NotBlank(message = "O nome do satélite não pode estar em branco")
        String nome,

        @NotNull(message = "A data de lançamento é obrigatória")
        LocalDate dataLancamento,

        @NotBlank(message = "O tipo de órbita é obrigatório (ex: LEO, GEO)")
        String tipoOrbita
) {}