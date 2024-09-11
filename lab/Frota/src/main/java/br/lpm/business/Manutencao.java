package br.lpm.business;

import java.time.LocalDate;

public class Manutencao {
  private LocalDate dataEntrega;
  private Veiculo veiculo;

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }
  public Veiculo getVeiculo() {
    return veiculo;
  }
  
  public Manutencao(LocalDate dataEntrega, Veiculo veiculo) {
    this.veiculo = veiculo;
    if (dataEntrega.isAfter(LocalDate.now().minusDays(1))) {
      this.dataEntrega = dataEntrega;
    }
  }
  
}
