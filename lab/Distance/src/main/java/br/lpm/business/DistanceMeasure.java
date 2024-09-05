package br.lpm.business;

public class DistanceMeasure {
  private Dataset dataset;

  public DistanceMeasure(Dataset dataset) {
    this.dataset = dataset;
  }

  public float[] normalizeField(String fieldName) {
    Pessoa[] pessoas = this.dataset.getAll();
    float[] normalized = new float[dataset.size()];

    for (int i = 0; i < normalized.length; i++) {
      switch (fieldName) {
        case "peso" ->
          normalized[i] = (pessoas[i].getPeso() - dataset.minPeso())
              / (dataset.maxPeso() - dataset.minPeso());
        case "altura" ->
          normalized[i] = (pessoas[i].getAltura() - dataset.minAltura())
              / (dataset.maxAltura() - dataset.minAltura());
        case "idade" ->
          normalized[i] = (pessoas[i].getIdade() - dataset.minIdade())
              / (dataset.maxIdade() - dataset.minIdade());
        case "renda" ->
          normalized[i] = (pessoas[i].getRenda() - dataset.minRenda())
              / (dataset.maxRenda() - dataset.minRenda());
      }
      ;
    }

    return normalized;
  }

  private int getEnumDistance(Enum<?> e1, Enum<?> e2){
    return e1 == e2 ? 0 : 1;
  }
  
  public float calcDistance(Pessoa first, Pessoa second) {
    float[] atributesDistances = new float[10];
    float absoluteDistance = 0;
    
    for (int i = 0; i < atributesDistances.length; i++) {
      atributesDistances[i] = switch (i) {
        case 0 -> getEnumDistance(first.getEscolaridade(), second.getEscolaridade());
        case 1 -> getEnumDistance(first.getEstadoCivil(), first.getEscolaridade());
        case 2 -> getEnumDistance(first.getMoradia(), second.getMoradia());
        case 3 -> getEnumDistance(first.getGenero(), second.getGenero());
        case 4 -> getEnumDistance(first.getHobby(), second.getHobby());
        default -> 1;
      };
    }

    return absoluteDistance;
  }
}
