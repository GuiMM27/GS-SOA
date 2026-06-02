package br.com.fiap.earthguard.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Satelite extends EquipamentoEspacial implements IMonitoramento {

    private String tipoOrbita; // Ex: LEO (Low Earth Orbit), GEO

    @Override
    public void registrarLeitura() {
        System.out.println("Leitura do satélite " + getNome() + " registrada com sucesso.");
    }

    @Override
    public boolean verificarAnomalia(Double temperatura, Double umidade) {
        return temperatura > 45.0 && umidade < 15.0;
    }
}