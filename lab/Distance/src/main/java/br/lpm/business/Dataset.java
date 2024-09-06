package br.lpm.business;

public class Dataset {
  private static final int MAX_PESSOAS = 55;
  private static Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
  private int qtdPessoas = 0;
  private DistanceMeasure distanceMeasure = new DistanceMeasure(this);

  public int getMaxPessoas() {
    return MAX_PESSOAS;
  }

  public void addPessoa(Pessoa p) {
    if (qtdPessoas >= MAX_PESSOAS || p == null || getPessoaByName(p.getNome()) != null) {
      return;
    }

    pessoas[qtdPessoas] = p;
    qtdPessoas++;
  }

  private void reorganiza(int posicaoVazia) {
    for (int i = posicaoVazia; i < qtdPessoas - 1; i++) {
      pessoas[i] = pessoas[i + 1];
    }
    pessoas[--qtdPessoas] = null;
  }

  public void removePessoa(Pessoa p) {
    for (int i = 0; i < qtdPessoas; i++) {
      if (p != null && pessoas[i] != null && p.equals(pessoas[i])) {
        reorganiza(i);
        return;
      }
    }
  }

  public void removePessoaByName(String nome) {
    removePessoa(getPessoaByName(nome));
  }

  public void replacePessoa(Pessoa velha, Pessoa nova) {
    if (velha == null || nova == null) {
      return;
    }

    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i] != null && velha.equals(pessoas[i])) {
        pessoas[i] = nova;
        return;
      }
    }
  }

  public Pessoa getPessoaByName(String nome) {
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
        return pessoas[i];
      }
    }
    return null;
  }

  public int getPessoaIndex(Pessoa pessoa) {
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i].equals(pessoa)) {
        return i;
      }
    }

    return -1;
  }

  public Pessoa[] getAll() {
    return pessoas;
  }

  public void removeAll() {
    pessoas = new Pessoa[MAX_PESSOAS];
    qtdPessoas = 0;
  }

  public int size() {
    return qtdPessoas;
  }

  private float maxFloatCalc(String atributo, Pessoa p, float res) {
    return switch (atributo) {
      case "altura" -> p.getAltura() > res ? p.getAltura() : res;
      case "renda" -> p.getRenda() > res ? p.getRenda() : res;
      default -> res;
    };
  }

  private float minFloatCalc(String atributo, Pessoa p, float res) {
    return switch (atributo) {
      case "altura" -> p.getAltura() < res ? p.getAltura() : res;
      case "renda" -> p.getRenda() < res ? p.getRenda() : res;
      default -> res;
    };
  }

  private float avgFloatCalc(String atributo, Pessoa p) {
    return switch (atributo) {
      case "altura" -> p.getAltura();
      case "renda" -> p.getRenda();
      default -> 0;
    };
  }

  private float floatCalcs(String calculo, String atributo) {
    float res =
        calculo.equals("MAX") ? Float.MIN_VALUE : calculo.equals("MIN") ? Float.MAX_VALUE : 0;

    for (int i = 0; i < qtdPessoas; i++) {
      switch (calculo) {
        case "MAX" -> {
          res = maxFloatCalc(atributo, pessoas[i], res);
        }
        case "MIN" -> {
          res = minFloatCalc(atributo, pessoas[i], res);
        }
        case "AVG" -> res += avgFloatCalc(atributo, pessoas[i]);
      }
    }

    return calculo.equals("AVG") ? res / qtdPessoas : res;
  }

  private int maxIntCalc(String atributo, Pessoa p, int res) {
    return switch (atributo) {
      case "peso" -> p.getPeso() > res ? p.getPeso() : res;
      case "idade" -> p.getIdade() > res ? p.getIdade() : res;
      default -> res;
    };
  }

  private int minIntCalc(String atributo, Pessoa p, int res) {
    return switch (atributo) {
      case "peso" -> p.getPeso() < res ? p.getPeso() : res;
      case "idade" -> p.getIdade() < res ? p.getIdade() : res;
      default -> res;
    };
  }

  private int avgIntCalc(String atributo, Pessoa p) {
    return switch (atributo) {
      case "peso" -> p.getPeso();
      case "idade" -> p.getIdade();
      default -> 0;
    };
  }

  private int intCalcs(String calculo, String atributo) {
    int res =
        calculo.equals("MAX") ? Integer.MIN_VALUE : calculo.equals("MIN") ? Integer.MAX_VALUE : 0;

    for (int i = 0; i < qtdPessoas; i++) {
      switch (calculo) {
        case "MAX" -> {
          res = maxIntCalc(atributo, pessoas[i], res);
        }
        case "MIN" -> {
          res = minIntCalc(atributo, pessoas[i], res);
        }
        case "AVG" -> res += avgIntCalc(atributo, pessoas[i]);
      }
    }

    return calculo.equals("AVG") ? res / qtdPessoas : res;
  }

  private float alturaCalcs(String calculo) {
    return floatCalcs(calculo, "altura");
  }

  public float maxAltura() {
    return alturaCalcs("MAX");
  }

  public float minAltura() {
    return alturaCalcs("MIN");
  }

  public float avgAltura() {
    return alturaCalcs("AVG");
  }

  private float rendaCalcs(String calculo) {
    return floatCalcs(calculo, "renda");
  }

  public float maxRenda() {
    return rendaCalcs("MAX");
  }

  public float minRenda() {
    return rendaCalcs("MIN");
  }

  public float avgRenda() {
    return rendaCalcs("AVG");
  }

  private int pesoCalcs(String calculo) {
    return intCalcs(calculo, "peso");
  }

  public int maxPeso() {
    return pesoCalcs("MAX");
  }

  public int minPeso() {
    return pesoCalcs("MIN");
  }

  public int avgPeso() {
    return pesoCalcs("AVG");
  }

  private int idadeCalcs(String calculo) {
    return intCalcs(calculo, "idade");
  }

  public int minIdade() {
    return idadeCalcs("MIN");
  }

  public int maxIdade() {
    return idadeCalcs("MAX");
  }

  public int avgIdade() {
    return idadeCalcs("AVG");
  }

  private float percentFloats(String atributo) {
    float percent = 0;
    for (int i = 0; i < qtdPessoas; i++) {
      switch (atributo) {
        case "adultness" -> percent = pessoas[i].getIdade() >= 18 ? percent + 1 : percent;
        case "happiness" -> percent = pessoas[i].isFeliz() ? percent + 1 : percent;
      }
    }

    return percent / qtdPessoas;
  }

  public float percentAdult() {
    return percentFloats("adultness");
  }

  public float percentFeliz() {
    return percentFloats("happiness");
  }

  private float percentEnums(Enum<?> valor) {
    float percent = 0;
    for (int i = 0; i < qtdPessoas; i++) {
      if (valor instanceof Genero) {
        percent = pessoas[i].getGenero() == valor ? percent + 1 : percent;
      } else if (valor instanceof EstadoCivil) {
        percent = pessoas[i].getEstadoCivil() == valor ? percent + 1 : percent;
      } else if (valor instanceof Escolaridade) {
        percent = pessoas[i].getEscolaridade() == valor ? percent + 1 : percent;
      } else if (valor instanceof Moradia) {
        percent = pessoas[i].getMoradia() == valor ? percent + 1 : percent;
      } else if (valor instanceof Hobby) {
        percent = pessoas[i].getHobby() == valor ? percent + 1 : percent;
      }
    }

    return percent / qtdPessoas;
  }

  public float percentGenero(Genero genero) {
    return percentEnums(genero);
  }

  public float percentEstadoCivil(EstadoCivil estadoCivil) {
    return percentEnums(estadoCivil);
  }

  public float percentEscolaridade(Escolaridade escolaridade) {
    return percentEnums(escolaridade);
  }

  public float percentMoradia(Moradia moradia) {
    return percentEnums(moradia);
  }

  public float percentHobby(Hobby hobby) {
    return percentEnums(hobby);
  }

  private Enum<?> modeEnums(String tipo) {
    Enum<?>[] valoresEnum = null;
    int[] recorrencia = null;

    for (int i = 0; i < qtdPessoas; i++) {
      switch (tipo) {
        case "Genero":
          valoresEnum = Genero.values();
          recorrencia = new int[valoresEnum.length];
          recorrencia[pessoas[i].getGenero().ordinal()]++;
          break;
        case "EstadoCivil":
          valoresEnum = EstadoCivil.values();
          recorrencia = new int[valoresEnum.length];
          recorrencia[pessoas[i].getEstadoCivil().ordinal()]++;
          break;
        case "Escolaridade":
          valoresEnum = Escolaridade.values();
          recorrencia = new int[valoresEnum.length];
          recorrencia[pessoas[i].getEscolaridade().ordinal()]++;
          break;
        case "Moradia":
          valoresEnum = Moradia.values();
          recorrencia = new int[valoresEnum.length];
          recorrencia[pessoas[i].getMoradia().ordinal()]++;
          break;
        case "Hobby":
          valoresEnum = Hobby.values();
          recorrencia = new int[valoresEnum.length];
          recorrencia[pessoas[i].getHobby().ordinal()]++;
          break;
      }
    }

    int maiorRecorrencia = Integer.MIN_VALUE;
    Enum<?> mode = null;
    for (int i = 0; i < recorrencia.length; i++) {
      if (recorrencia[i] > maiorRecorrencia) {
        maiorRecorrencia = recorrencia[i];
        mode = valoresEnum[i];
      }
    }

    return mode;
  }

  public EstadoCivil modeEstadoCivil() {
    return (EstadoCivil) modeEnums("EstadoCivil");
  }

  public Escolaridade modeEscolaridade() {
    return (Escolaridade) modeEnums("Escolaridade");
  }

  public Genero modeGenero() {
    return (Genero) modeEnums("Genero");
  }

  public Moradia modeMoradia() {
    return (Moradia) modeEnums("Moradia");
  }

  public Hobby modeHobby() {
    return (Hobby) modeEnums("Hobby");
  }

  public float[] calcDistanceVector(Pessoa pessoa) {
    float[] distanceVector = new float[qtdPessoas];

    for (int i = 0; i < size(); i++) {
      distanceVector[i] = distanceMeasure.calcDistance(pessoa, pessoas[i]);
    }

    return distanceVector;
  }

  public float[][] calcDistanceMatrix() {
    float[][] distanceMatrix = new float[qtdPessoas][qtdPessoas];

    for (int i = 0; i < size(); i++) {
      for (int j = i; j < size(); j++) {
        if (i == j) {
          distanceMatrix[i][j] = 0;
        } else {
          distanceMatrix[i][j] = distanceMeasure.calcDistance(pessoas[i], pessoas[j]);
        }
      }
    }

    return distanceMatrix;
  }

  public Pessoa[] getSimilar(Pessoa pessoa, int n) {
    Pessoa[] similars = new Pessoa[n];
    float[] distances = calcDistanceVector(pessoa);

    float[] minDistances = new float[n];
    for (int i = 0; i < n; i++) {
      minDistances[i] = Float.MAX_VALUE;
    }

    for (int i = 0; i < size(); i++) {
      if (i != getPessoaIndex(pessoa)) {
        for (int j = 0; j < n; j++) {
          if (distances[i] < minDistances[j]) {
            for (int k = n - 1; k > j; k--) {
              minDistances[k] = minDistances[k - 1];
              similars[k] = similars[k - 1];
            }

            minDistances[j] = distances[i];
            similars[j] = pessoas[i];
            break;
          }
        }
      }
    }

    return similars;
  }
}
