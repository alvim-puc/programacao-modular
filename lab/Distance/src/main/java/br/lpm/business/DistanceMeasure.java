package br.lpm.business;

public class DistanceMeasure {
  private Dataset dataset;

  public DistanceMeasure(Dataset dataset) {
    this.dataset = dataset;
  }

  public float[] normalizeField(String fieldName) {
    Pessoa[] pessoas = this.dataset.getAll();
    float[] normalized = new float[dataset.size()];

    for (int i = 0; i < normalized.length; i++){
      switch (fieldName){
        case "Peso" -> normalized[i] = (pessoas[i].getPeso() - dataset.minPeso()) / (dataset.maxPeso() - dataset.minPeso());
      };
    }

    return normalized;
  }  
}
