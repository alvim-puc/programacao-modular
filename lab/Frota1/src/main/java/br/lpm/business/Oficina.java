package br.lpm.business;

public class Oficina {
  private String nome;
  private String addr;
  private static int qtdEmManutencao = 0;
  private static final int MAX_EM_MANUTENCAO = 100;
  private Manutencao[] manutencoes = new Manutencao[MAX_EM_MANUTENCAO];
  
  public String getNome() {
    return nome;
  }
  public String getAddr() {
    return addr;
  }
  public static int getQtdEmManutencao() {
    return qtdEmManutencao;
  }
  public static int getMaxEmManutencao() {
    return MAX_EM_MANUTENCAO;
  }
  public Manutencao[] getManutencoes() {
    return manutencoes;
  }

  public void addEmTransito(Manutencao manutencao) {
    if (qtdEmManutencao + Transito.getQtdEmTransito() < MAX_EM_MANUTENCAO
        && manutencao.getVeiculo().getEstado() != Estado.MANUTENÇÃO) {
      manutencoes[qtdEmManutencao] = manutencao;
      qtdEmManutencao++;
    }
  }

  public void entregaVeiculo(Veiculo veiculo) {
    for (int i = 0; i < qtdEmManutencao; i++) {
      if (veiculo.equals(manutencoes[i].getVeiculo())) {
        manutencoes[i] = null;
        break;
      }
    }
    qtdEmManutencao--;
  }
}
