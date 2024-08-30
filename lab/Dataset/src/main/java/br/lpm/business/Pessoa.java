package br.lpm.business;

import java.time.LocalDate;

public class Pessoa {
  private String nome;
  private float altura;
  private int peso;
  private float renda;
  private LocalDate dataNascimento;
  private String naturalidade;
  private Genero genero;
  private EstadoCivil estadoCivil;
  private Escolaridade escolaridade;
  private Moradia moradia;
  private Hobby hobby;
  private boolean feliz;

  public Pessoa() {}

  public Pessoa(
      String nome,
      float altura,
      int peso,
      float renda,
      LocalDate dataNascimento,
      String naturalidade,
      Genero genero,
      EstadoCivil estadoCivil,
      Escolaridade escolaridade,
      Moradia moradia,
      Hobby hobby,
      boolean feliz) {

    this.setNome(nome);
    this.setAltura(altura);
    this.setPeso(peso);
    this.setRenda(renda);
    this.setDataNascimento(dataNascimento);
    this.setNaturalidade(naturalidade);
    this.setGenero(genero);
    this.setEstadoCivil(estadoCivil);
    this.setEscolaridade(escolaridade);
    this.setMoradia(moradia);
    this.setHobby(hobby);
    this.setFeliz(feliz);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (validateString(nome)) {
      this.nome = nome;
    }
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    if (altura > 0 && altura < 2.6f) {
      this.altura = altura;
    }
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    if (peso > 0 && peso < 600) {
      this.peso = peso;
    }
  }

  public float getRenda() {
    return renda;
  }

  public void setRenda(float renda) {
    if (renda > 0) {
      this.renda = renda;
    }
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    if (LocalDate.now().isAfter(dataNascimento)) {
      this.dataNascimento = dataNascimento;
    }
  }

  public String getNaturalidade() {
    return naturalidade;
  }

  public void setNaturalidade(String naturalidade) {
    if (validateString(naturalidade)) {
      this.naturalidade = naturalidade;
    }
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Escolaridade getEscolaridade() {
    return escolaridade;
  }

  public void setEscolaridade(Escolaridade escolaridade) {
    this.escolaridade = escolaridade;
  }

  public Moradia getMoradia() {
    return moradia;
  }

  public void setMoradia(Moradia moradia) {
    this.moradia = moradia;
  }

  public Hobby getHobby() {
    return hobby;
  }

  public void setHobby(Hobby hobby) {
    this.hobby = hobby;
  }

  public boolean isFeliz() {
    return feliz;
  }

  public void setFeliz(boolean feliz) {
    this.feliz = feliz;
  }

  private boolean validateString(String str) {
    char[] chars = str.toCharArray();

    for (char c : chars) {
      if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return "Informações da Pessoa:\n"
        + "======================\n"
        + "Nome:           "
        + (nome == null ? "Não informado" : nome)
        + "\n"
        + "Altura:         "
        + String.format("%.2f", altura)
        + " metros\n"
        + "Peso:           "
        + peso
        + " kg\n"
        + "Renda:          "
        + String.format("R$ %.2f", renda)
        + "\n"
        + "Data de Nasc.:  "
        + dataNascimento
        + "\n"
        + "Naturalidade:   "
        + (naturalidade == null ? "Não informado" : naturalidade)
        + "\n"
        + "Gênero:         "
        + genero
        + "\n"
        + "Estado Civil:   "
        + estadoCivil
        + "\n"
        + "Escolaridade:   "
        + escolaridade
        + "\n"
        + "Moradia:        "
        + moradia
        + "\n"
        + "Hobby:          "
        + hobby
        + "\n"
        + "Está feliz?     "
        + (feliz ? "Sim" : "Não")
        + "\n"
        + "======================";
  }
}
