package br.lpm.business;

public class Dataset {
  private static final int MAX_PESSOAS = 55;
  private static Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
  private int qtdPessoas = 0;

  public int getMaxPessoas() {
    return MAX_PESSOAS;
  }

  public void addPessoa(Pessoa p) {
    pessoas[qtdPessoas] = p;
    qtdPessoas++;
  }

  private void reorganiza(int posicaoVazia) {
    for (int i = posicaoVazia; i < qtdPessoas; i++) {
      pessoas[i] = pessoas[i + 1];
    }
    qtdPessoas--;
  }

  public void removePessoa(Pessoa p) {
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i] != null && p.equals(pessoas[i])) {
        reorganiza(i);
        return;
      }
    }
  }

  public void removePessoaByName(String nome) {
    removePessoa(getPessoaByName(nome));
  }

  public void replacePessoa(Pessoa velha, Pessoa nova) {
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

  private float alturaCalcs(String calculo) {
    float res = pessoas[0].getAltura();
    for (int i = 0; i < qtdPessoas; i++) {
      switch (calculo) {
        case "MAX" -> res = res > pessoas[i].getAltura() ? res : pessoas[i].getAltura();
        case "MIN" -> res = res < pessoas[i].getAltura() ? res : pessoas[i].getAltura();
        case "AVG" -> res += pessoas[++i].getAltura();
      }
    }

    return calculo.equals("AVG") ? res / qtdPessoas : res;
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

  private int pesoCalcs(String calculo) {
    int res = pessoas[0].getPeso();
    for (int i = 0; i < qtdPessoas; i++) {
      switch (calculo) {
        case "MAX" -> res = res > pessoas[i].getPeso() ? res : pessoas[i].getPeso();
        case "MIN" -> res = res < pessoas[i].getPeso() ? res : pessoas[i].getPeso();
        case "AVG" -> res += pessoas[++i].getPeso();
      }
    }

    return calculo.equals("AVG") ? res / qtdPessoas : res;
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

  public float percentAdult() {
    float percent = 0;
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i].getIdade() >= 18) {
        percent++;
      }
    }

    return percent / qtdPessoas;
  }

  public float percentFeliz() {
    float percent = 0;
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i].isFeliz()) {
        percent++;
      }
    }

    return percent / qtdPessoas;
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

}
