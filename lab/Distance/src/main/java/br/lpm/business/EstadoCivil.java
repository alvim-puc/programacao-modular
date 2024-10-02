package br.lpm.business;

public enum EstadoCivil {
  SOLTEIRO(0),
  CASADO(1),
  VIUVO(2),
  SEPARADO(3),
  DIVORCIADO(4),
  UNIAO_ESTAVEL(5);

  private int value;

  public int getValue() {
    return value;
  }

  private EstadoCivil(int value) {
    this.value = value;
  }

  public static EstadoCivil parseEstadoCivil(String estadoCivil) {
    return switch(estadoCivil) {
      case "Solteiro" -> SOLTEIRO;
      case "Casado" -> CASADO;
      case "Viuvo" -> VIUVO;
      case "Separado" -> SEPARADO;
      case "Divorciado" -> DIVORCIADO;
      case "União Estavel" -> UNIAO_ESTAVEL;
      default -> null;
    };
  }
}
