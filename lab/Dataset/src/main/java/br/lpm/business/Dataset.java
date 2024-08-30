package br.lpm.business;

public class Dataset {
  private static final int MAX_PESSOAS = 55;
  private static Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
  private int qtdPessoas = 0;

  public int getMaxPessoas() {
    return MAX_PESSOAS;
  }

  public void addPessoas(Pessoa p) {
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

  public void removePessoaByName(String name) {
    removePessoa(getPessoaByName(name));
  }

  public void replacePessoa(Pessoa velha, Pessoa nova) {
    for (int i = 0; i < qtdPessoas; i++) {
      if (pessoas[i] != null && velha.equals(pessoas[i])) {
        pessoas[i] = nova;
        return;
      }
    }
  }

  public Pessoa getPessoaByName(String name) {
    for (Pessoa p : pessoas) {
      if (p != null && name.equalsIgnoreCase(p.getNome())) {
        return p;
      }
    }
    return null;
  }

  public Pessoa[] getAll() {
    return pessoas;
  }

  public void removeAll() {
    pessoas = new Pessoa[MAX_PESSOAS];
  }

  public int size() {
    return qtdPessoas;
  }

  private float alturaCalcs(String calculo) {
    float res = pessoas[0].getAltura();
    for (Pessoa p : pessoas) {
      switch (calculo) {
        case "MAX" -> res = res > p.getAltura() ? res : p.getAltura();
        case "MIN" -> res = res < p.getAltura() ? res : p.getAltura();
        case "AVG" -> res += p.getAltura();
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
    for (Pessoa pessoa : pessoas) {
      switch (calculo) {
        case "MAX" -> res = res > pessoa.getPeso() ? res : pessoa.getPeso();
        case "MIN" -> res = res < pessoa.getPeso() ? res : pessoa.getPeso();
        case "AVG" -> res += pessoa.getPeso();
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

  
}
