package br.lpm.business;

public class Motorista {
  private int id;
  private String nome;
  private Veiculo veiculo;

  public Motorista(int id, String nome, Veiculo veiculo) {
    this.id = id;
    this.nome = nome;
    this.veiculo = veiculo;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public int getId() {
    return id;
  }
  public Veiculo getVeiculo() {
    return veiculo;
  }
  public void replaceVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }
  
  
}
