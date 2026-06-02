package br.com.fiap.earthguard.model;

public interface IMonitoramento {
    void registrarLeitura();
    boolean verificarAnomalia(Double temperatura, Double umidade);
}