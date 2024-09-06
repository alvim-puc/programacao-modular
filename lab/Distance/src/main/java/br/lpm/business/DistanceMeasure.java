package br.lpm.business;

public class DistanceMeasure {
  private Dataset dataset;
  private static final int QTD_ATRIBUTOS = 10;

  public DistanceMeasure(Dataset dataset) {
    this.dataset = dataset;
  }

  public float[] normalizeField(String fieldName) {
    Pessoa[] pessoas = this.dataset.getAll();
    float[] normalized = new float[dataset.size()];
    float max, min;

    switch (fieldName) {
      case "peso" -> {
        max = dataset.maxPeso();
        min = dataset.minPeso();
      }
      case "altura" -> {
        max = dataset.maxAltura();
        min = dataset.minAltura();
      }
      case "idade" -> {
        max = dataset.maxIdade();
        min = dataset.minIdade();
      }
      case "renda" -> {
        max = dataset.maxRenda();
        min = dataset.minRenda();
      }
      default -> {
        return normalized;
      }
    }

    if (max == min) {
      for (int i = 0; i < normalized.length; i++) {
        normalized[i] = 0;
      }
      return normalized;
    }

    for (int i = 0; i < normalized.length; i++) {
      switch (fieldName) {
        case "peso" -> normalized[i] = (pessoas[i].getPeso() - min) / (max - min);
        case "altura" -> normalized[i] = (pessoas[i].getAltura() - min) / (max - min);
        case "idade" -> normalized[i] = (pessoas[i].getIdade() - min) / (max - min);
        case "renda" -> normalized[i] = (pessoas[i].getRenda() - min) / (max - min);
      }
    }

    return normalized;
  }

  private int getEnumDistance(Enum<?> e1, Enum<?> e2) {
    return e1 == e2 ? 0 : 1;
  }

  private float getNumericDistance(String fieldName, Pessoa first, Pessoa second) {
    float[] normalized = normalizeField(fieldName);
    float distance = 0;

    int firstIndex = dataset.getPessoaIndex(first);
    int secondIndex = dataset.getPessoaIndex(second);

    distance = normalized[firstIndex] - normalized[secondIndex];

    return Math.abs(distance);
  }

  private boolean xand(boolean a, boolean b) {
    return !(a ^ b);
  }

  public float calcDistance(Pessoa first, Pessoa second) {
    float[] atributesDistances = new float[QTD_ATRIBUTOS];
    float sum = 0;

    for (int i = 0; i < atributesDistances.length; i++) {
      atributesDistances[i] =
          switch (i) {
            case 0 -> getEnumDistance(first.getEscolaridade(), second.getEscolaridade());
            case 1 -> getEnumDistance(first.getEstadoCivil(), first.getEstadoCivil());
            case 2 -> getEnumDistance(first.getMoradia(), second.getMoradia());
            case 3 -> getEnumDistance(first.getGenero(), second.getGenero());
            case 4 -> getEnumDistance(first.getHobby(), second.getHobby());
            case 5 -> getNumericDistance("peso", first, second);
            case 6 -> getNumericDistance("altura", first, second);
            case 7 -> getNumericDistance("idade", first, second);
            case 8 -> getNumericDistance("renda", first, second);
            case 9 -> xand(first.isFeliz(), second.isFeliz()) ? 0 : 1;
            default -> 1;
          };
      sum += atributesDistances[i] * atributesDistances[i];
    }

    double absoluteDistance = sum;

    return (float) Math.sqrt(absoluteDistance / QTD_ATRIBUTOS);
  }
}
