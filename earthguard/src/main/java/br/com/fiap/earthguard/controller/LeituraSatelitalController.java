package br.com.fiap.earthguard.controller;

import br.com.fiap.earthguard.dto.LeituraSatelitalRequestDTO;
import br.com.fiap.earthguard.model.LeituraSatelital;
import br.com.fiap.earthguard.service.LeituraSatelitalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leituras")
public class LeituraSatelitalController {

    private final LeituraSatelitalService service;

    public LeituraSatelitalController(LeituraSatelitalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeituraSatelital> registrarLeitura(@Valid @RequestBody LeituraSatelitalRequestDTO dto) {
        LeituraSatelital leituraSalva = service.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(leituraSalva);
    }
}