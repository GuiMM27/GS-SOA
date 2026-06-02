package br.com.fiap.earthguard.service;

import br.com.fiap.earthguard.dto.LeituraSatelitalRequestDTO;
import br.com.fiap.earthguard.exception.RecursoNaoEncontradoException;
import br.com.fiap.earthguard.model.LeituraSatelital;
import br.com.fiap.earthguard.model.Satelite;
import br.com.fiap.earthguard.repository.LeituraSatelitalRepository;
import br.com.fiap.earthguard.repository.SateliteRepository;
import org.springframework.stereotype.Service;

@Service
public class LeituraSatelitalService {

    private final LeituraSatelitalRepository leituraRepository;
    private final SateliteRepository sateliteRepository;

    public LeituraSatelitalService(LeituraSatelitalRepository leituraRepository, SateliteRepository sateliteRepository) {
        this.leituraRepository = leituraRepository;
        this.sateliteRepository = sateliteRepository;
    }

    public LeituraSatelital registrar(LeituraSatelitalRequestDTO dto) {
        // 1. Busca o satélite. Se não achar, lança a nossa exceção personalizada
        Satelite satelite = sateliteRepository.findById(dto.sateliteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Satélite ID " + dto.sateliteId() + " não localizado na base."));

        // 2. Converte o DTO para a Entidade
        LeituraSatelital leitura = new LeituraSatelital();
        leitura.setTemperatura(dto.temperatura());
        leitura.setUmidade(dto.umidade());
        leitura.setDataHoraRegistro(dto.dataHoraRegistro());
        leitura.setSatelite(satelite);

        // 3. Verifica Anomalias (Aplicando o Polimorfismo e Regra de Negócio)
        boolean anomalia = satelite.verificarAnomalia(dto.temperatura(), dto.umidade());
        if (anomalia) {
            System.err.println("⚠ ALERTA CRÍTICO: Risco detectado pelo satélite " + satelite.getNome() +
                    " | Temp: " + dto.temperatura() + "°C | Umid: " + dto.umidade() + "%");
        } else {
            satelite.registrarLeitura(); // Print simples de sucesso
        }

        // 4. Salva no banco
        return leituraRepository.save(leitura);
    }
}