package br.lpm.business;

import java.time.LocalDate;

public class Rota {
  private String origem;
  private String destino;
  private LocalDate data;
  
  public Rota(String origem, String destino, LocalDate data) {
    this.destino = destino;
    this.origem = origem;
    this.data = data;
  }
  
  public String getOrigem() {
    return origem;
  }
  public String getDestino() {
    return destino;
  }
  public LocalDate getData() {
    return data;
  }
}
