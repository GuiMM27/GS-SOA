package br.com.fiap.earthguard.controller;

import br.com.fiap.earthguard.dto.SateliteRequestDTO;
import br.com.fiap.earthguard.model.Satelite;
import br.com.fiap.earthguard.service.SateliteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/satelites")
public class SateliteController {

    private final SateliteService service;

    public SateliteController(SateliteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Satelite> cadastrar(@Valid @RequestBody SateliteRequestDTO dto) {
        Satelite sateliteSalvo = service.cadastrar(dto);
        // Retorna status 201 (Created) e os dados do satélite salvo no banco
        return ResponseEntity.status(HttpStatus.CREATED).body(sateliteSalvo);
    }
}