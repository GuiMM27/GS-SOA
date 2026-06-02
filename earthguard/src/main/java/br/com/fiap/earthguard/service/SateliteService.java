package br.com.fiap.earthguard.service;

import br.com.fiap.earthguard.dto.SateliteRequestDTO;
import br.com.fiap.earthguard.model.Satelite;
import br.com.fiap.earthguard.repository.SateliteRepository;
import org.springframework.stereotype.Service;

@Service
public class SateliteService {

    private final SateliteRepository repository;

    public SateliteService(SateliteRepository repository) {
        this.repository = repository;
    }

    public Satelite cadastrar(SateliteRequestDTO dto) {
        Satelite satelite = new Satelite();
        satelite.setNome(dto.nome());
        satelite.setDataLancamento(dto.dataLancamento());
        satelite.setTipoOrbita(dto.tipoOrbita());
        satelite.setStatusOperacional(true); // Todo satélite novo entra como operacional

        return repository.save(satelite);
    }
}