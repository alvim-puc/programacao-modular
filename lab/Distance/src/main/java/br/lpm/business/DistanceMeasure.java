package br.lpm.business;

public class DistanceMeasure {
  private Dataset dataset;
  private static final int QTD_ATRIBUTOS = 10;

  public DistanceMeasure(Dataset dataset) {
    this.dataset = dataset;
  }

  private int getEnumDistance(Enum<?> e1, Enum<?> e2) {
    return e1 == e2 ? 0 : 1;
  }

  private float getNumericDistance(String fieldName, Pessoa first, Pessoa second) {
    Pessoa datasetFirstPerson = dataset.getPessoaByName(first.getNome());
    Pessoa datasetSecondPerson = dataset.getPessoaByName(second.getNome());

    return Math.abs(
        switch (fieldName) {
          case "peso" -> datasetFirstPerson.getPeso() - datasetSecondPerson.getPeso();
          case "idade" -> datasetFirstPerson.getIdade() - datasetSecondPerson.getIdade();
          case "renda" -> datasetFirstPerson.getRenda() - datasetSecondPerson.getRenda();
          case "altura" -> datasetFirstPerson.getAltura() - datasetSecondPerson.getAltura();
          default -> 1;
        });
  }

  private boolean XAND(boolean a, boolean b) {
    return !(a ^ b);
  }

  public float calcDistance(Pessoa first, Pessoa second) {
    double distance = 0;

    distance += Math.pow(getEnumDistance(first.getEscolaridade(), second.getEscolaridade()), 2);
    distance += Math.pow(getEnumDistance(first.getEstadoCivil(), first.getEstadoCivil()), 2);
    distance += Math.pow(getEnumDistance(first.getMoradia(), second.getMoradia()), 2);
    distance += Math.pow(getEnumDistance(first.getGenero(), second.getGenero()), 2);
    distance += Math.pow(getEnumDistance(first.getHobby(), second.getHobby()), 2);
    distance += Math.pow(getNumericDistance("peso", first, second), 2);
    distance += Math.pow(getNumericDistance("idade", first, second), 2);
    distance += Math.pow(getNumericDistance("renda", first, second), 2);
    distance += Math.pow(getNumericDistance("altura", first, second), 2);
    distance += XAND(first.isFeliz(), second.isFeliz()) ? 0 : 1;

    return (float) Math.sqrt(distance / QTD_ATRIBUTOS);
  }
}
