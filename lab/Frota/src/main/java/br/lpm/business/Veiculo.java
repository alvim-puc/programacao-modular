package br.lpm.business;

public class Veiculo {
  private String modelo;
  private String placa;
  private int ano;
  private float quilometragem;
  private Estado estado;

  public Veiculo(String modelo, int ano, String placa, Estado estado, float quilometragem) {
    this.ano = ano;
    this.placa = placa;
    this.modelo = modelo;
    this.estado = estado;
    this.updateQulometragem(quilometragem);
  }

  public String getModelo() {
    return modelo;
  }
  public String getPlaca() {
    return placa;
  }
  public int getAno() {
    return ano;
  }
  public float getQuilometragem() {
    return quilometragem;
  }
  public void updateQulometragem(float quilometragem) {
    this.quilometragem += quilometragem;
  }
  public Estado getEstado() {
    return estado;
  }
  public void changeEstado(Estado estado) {
    this.estado = estado;
  }
  
}
