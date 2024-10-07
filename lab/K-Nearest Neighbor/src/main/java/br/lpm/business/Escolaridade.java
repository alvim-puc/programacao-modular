package br.lpm.business;

public enum Escolaridade {
  NENHUMA(0),
  FUNDAMENTAL(1),
  MEDIO(2),
  SUPERIOR(3),
  POS_GRADUACAO(4);

  private int value;

  public int getValue() {
    return value;
  }

  private Escolaridade(int value) {
    this.value = value;
  }

  public static Escolaridade parseEscolaridade(String escolaridade) {
    return switch(escolaridade) {
      case "Nenhuma" -> Escolaridade.NENHUMA;
      case "Ensino Fundamental" -> Escolaridade.FUNDAMENTAL;
      case "Ensino Médio" -> Escolaridade.MEDIO;
      case "Ensino Superior" -> Escolaridade.SUPERIOR;
      case "Pós-graduação, Mestrado ou Doutorado" -> Escolaridade.POS_GRADUACAO;
      default -> null;
    };
  }
}
