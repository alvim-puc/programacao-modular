package business;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.function.IntPredicate;

public class Pessoa {
  private String nome;
  private float altura;
  private float peso;
  private LocalDate dataNascimento;
  private EstadoCivil estadoCivil;
  private FormacaoAcademica formacaoAcademica;
  private Profissao profissao;
  private boolean vidaSocial;
  private boolean hobby;
  private int atividadeFisica;
  private int saude;

  public Pessoa() {}

  public Pessoa(
      String nome,
      float altura,
      float peso,
      LocalDate dataNascimento,
      EstadoCivil estadoCivil,
      FormacaoAcademica formacaoAcademica,
      Profissao profissao,
      boolean vidaSocial,
      boolean hobby,
      int atividadeFisica,
      int saude) {

    this.setNome(nome);
    this.setAltura(altura);
    this.setPeso(peso);
    this.setDataNascimento(dataNascimento);
    this.setEstadoCivil(estadoCivil);
    this.setFormacaoAcademica(formacaoAcademica);
    this.setProfissao(profissao);
    this.setVidaSocial(vidaSocial);
    this.setHobby(hobby);
    this.setAtividadeFisica(atividadeFisica);
    this.setSaude(saude);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    IntPredicate checkName =
        letter ->
            (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z') || letter == ' ';

    if (!nome.chars().allMatch(checkName)) {
      throw new IllegalArgumentException("Nome deve conter apenas letras e espaços");
    }

    this.nome = nome;
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    if (altura < 0 || altura > 3) {
      throw new IllegalArgumentException("Altura deve ser maior que 0 e menor que 3 metros");
    }

    this.altura = altura;
  }

  public float getPeso() {
    return peso;
  }

  public void setPeso(float peso) {
    if (peso < 0 || peso > 500) {
      throw new IllegalArgumentException("Peso deve ser maior que 0 e menor que 500 kg");
    }

    this.peso = peso;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    if (LocalDate.now().isBefore(dataNascimento)) {
      throw new IllegalArgumentException("Data de nascimento deve ser menor que a data atual");
    }

    this.dataNascimento = dataNascimento;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    if (!EnumSet.allOf(EstadoCivil.class).contains(estadoCivil) || estadoCivil == null) {
      throw new IllegalArgumentException("Estado civil não pode ser nulo");
    }

    this.estadoCivil = estadoCivil;
  }

  public FormacaoAcademica getFormacaoAcademica() {
    return formacaoAcademica;
  }

  public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
    if (!EnumSet.allOf(FormacaoAcademica.class).contains(formacaoAcademica)
        || formacaoAcademica == null) {
      throw new IllegalArgumentException("Formação acadêmica não pode ser nula");
    }

    this.formacaoAcademica = formacaoAcademica;
  }

  public Profissao getProfissao() {
    return profissao;
  }

  public void setProfissao(Profissao profissao) {
    if (!EnumSet.allOf(Profissao.class).contains(profissao) || profissao == null) {
      throw new IllegalArgumentException("Profissão não pode ser nula");
    }

    this.profissao = profissao;
  }

  public boolean isVidaSocial() {
    return vidaSocial;
  }

  public void setVidaSocial(boolean vidaSocial) {
    this.vidaSocial = vidaSocial;
  }

  public boolean isHobby() {
    return hobby;
  }

  public void setHobby(boolean hobby) {
    this.hobby = hobby;
  }

  public int getAtividadeFisica() {
    return atividadeFisica;
  }

  public void setAtividadeFisica(int atividadeFisica) {
    if (atividadeFisica < 0 || atividadeFisica > 7) {
      throw new IllegalArgumentException(
          "Atividade física deve ser maior que 0 e menor que 7 dias");
    }

    this.atividadeFisica = atividadeFisica;
  }

  public int getSaude() {
    return saude;
  }

  public void setSaude(int saude) {
    if (saude < 1 || saude > 10) {
      throw new IllegalArgumentException("Saude deve ser maior que 1 e menor que 10");
    }

    this.saude = saude;
  }

  public String toString() {
    return ("Nome: "
        + nome
        + "\n"
        + "Altura: "
        + altura
        + "\n"
        + "Peso: "
        + peso
        + "\n"
        + "Data de nascimento: "
        + dataNascimento
        + "\n"
        + "Estado civil: "
        + estadoCivil
        + "\n"
        + "Formação acadêmica: "
        + formacaoAcademica
        + "\n"
        + "Profissão: "
        + profissao
        + "\n"
        + "Vida social: "
        + vidaSocial
        + "\n"
        + "Hobby: "
        + hobby
        + "\n"
        + "Atividade física: "
        + atividadeFisica
        + "\n"
        + "Saude: "
        + saude
        + "\n");
  }
}
