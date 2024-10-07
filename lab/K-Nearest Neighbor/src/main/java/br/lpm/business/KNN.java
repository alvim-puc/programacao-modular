package br.lpm.business;

public class KNN {
  private Dataset dataset;
  private int k;

  public KNN(Dataset dataset, int k) {
    this.dataset = dataset;
    this.k = k < 0 ? 0 : k;
  }

  public boolean classifyFeliz(Pessoa pessoa) {
    if (k <= 0) {
      return pessoa.isFeliz();
    }

    Pessoa[] neighbors = dataset.getSimilar(pessoa, k);

    int countTrue = 0;
    int countFalse = 0;

    for (Pessoa neighbor : neighbors) {
      if (neighbor.isFeliz()) {
        countTrue++;
      } else {
        countFalse++;
      }
    }
    
    return countTrue > countFalse;
  }
  
}
