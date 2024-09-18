package br.lpm.business;

public final class Transito {
  private static final int MAX_EM_TRANSITO = 100;
  private static Rota[] rotas = new Rota[MAX_EM_TRANSITO];
  private static Veiculo[] veiculos = new Veiculo[MAX_EM_TRANSITO];
  private static int qtdEmTransito = 0;

  public Veiculo[] getVeiculos() {
    return veiculos;
  }

  public Rota[] geRotas() {
    return rotas;
  }

  public static int getMaxEmTransito() {
    return MAX_EM_TRANSITO;
  }

  public static int getQtdEmTransito() {
    return qtdEmTransito;
  }

  public void addEmTransito(Rota rota, Veiculo veiculo) {
    if (qtdEmTransito + Oficina.getQtdEmManutencao() < MAX_EM_TRANSITO
        && veiculo.getEstado() != Estado.TRANSITO) {
      rotas[qtdEmTransito] = rota;
      veiculos[qtdEmTransito] = veiculo;
      qtdEmTransito++;
    }
  }

  public void removeEmTransito(Veiculo veiculo) {
    for (int i = 0; i < qtdEmTransito; i++) {
      if (veiculo.equals(veiculos[i])) {
        rotas[i] = null;
        veiculos[i] = null;
        break;
      }
    }
    qtdEmTransito--;
  }
}
