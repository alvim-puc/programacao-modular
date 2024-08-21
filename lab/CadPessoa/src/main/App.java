package main;

import business.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class App {
  public static final int MAX_PEOPLE = 55;
  public static int lengthPeople = 0;
  public static Pessoa[] pessoas = new Pessoa[MAX_PEOPLE];

  public static int menu(Scanner reader) {
    int choice;

    System.out.println("---------------- MENU -----------------");
    System.out.println("1. Cadastrar uma pessoa");
    System.out.println("2. Listar pessoas");
    System.out.println("0. Sair");
    System.out.print("Opção: ");
    choice = reader.nextInt();
    System.out.println("---------------------------------------");

    return choice;
  }

  public static void registerPerson(Scanner reader) {
    try {
      int choiceEnums;

      System.out.print("Digite seu nome: ");
      String nome = reader.nextLine();

      System.out.print("Insira sua altura: ");
      float altura = reader.nextFloat();

      System.out.print("Insira seu peso: ");
      float peso = reader.nextFloat();

      reader.nextLine();

      System.out.print("Insira sua data de nascimento no formato AAAA-MM-DD: ");
      String dataNascimento = reader.nextLine();
      LocalDate data = LocalDate.parse(dataNascimento);

      System.out.println("Qual o seu estado civil? ");
      System.out.println("1. Solteiro");
      System.out.println("2. Casado");
      System.out.println("3. União estável");
      System.out.println("4. Divorciado");
      System.out.println("5. Separado");
      System.out.println("6. Viúvo");
      System.out.print("Opção: ");
      choiceEnums = reader.nextInt();
      EstadoCivil estadoCivil =
          EstadoCivil.valueOf(
              switch (choiceEnums) {
                case 1 -> EstadoCivil.SOLTEIRO.toString();
                case 2 -> EstadoCivil.CASADO.toString();
                case 3 -> EstadoCivil.UNIAO_ESTAVEL.toString();
                case 4 -> EstadoCivil.DIVORCIADO.toString();
                case 5 -> EstadoCivil.SEPARADO.toString();
                case 6 -> EstadoCivil.VIUVO.toString();
                default -> EstadoCivil.SOLTEIRO.toString();
              });

      System.out.println("Qual a sua formação acadêmica? ");
      System.out.println("1. Nenhuma");
      System.out.println("2. Básica");
      System.out.println("3. Média");
      System.out.println("4. Superior");
      System.out.print("Opção: ");
      choiceEnums = reader.nextInt();
      FormacaoAcademica formacaoAcademica =
          FormacaoAcademica.valueOf(
              switch (choiceEnums) {
                case 1 -> FormacaoAcademica.NENHUMA.toString();
                case 2 -> FormacaoAcademica.BASICA.toString();
                case 3 -> FormacaoAcademica.MEDIA.toString();
                case 4 -> FormacaoAcademica.SUPERIOR.toString();
                default -> FormacaoAcademica.NENHUMA.toString();
              });

      System.out.println("Qual a sua profissão? ");
      System.out.println("1. Desempregado");
      System.out.println("2. Estudante");
      System.out.println("3. Autônomo");
      System.out.println("4. CLT");
      System.out.println("5. Empresário");
      System.out.print("Opção: ");
      choiceEnums = reader.nextInt();
      Profissao profissao =
          Profissao.valueOf(
              switch (choiceEnums) {
                case 1 -> Profissao.DESEMPREGADO.toString();
                case 2 -> Profissao.ESTUDANTE.toString();
                case 3 -> Profissao.AUTONOMO.toString();
                case 4 -> Profissao.CLT.toString();
                case 5 -> Profissao.EMPRESARIO.toString();
                default -> Profissao.DESEMPREGADO.toString();
              });

      System.out.println("Você tem vida social? 'true' ou 'false'");
      boolean vidaSocial = reader.nextBoolean();

      System.out.println("Você tem algum hobby? 'true' ou 'false'");
      boolean hobby = reader.nextBoolean();

      System.out.println("Quantos dias você faz atividade física por semana? 0 a 7");
      int atividadeFisica = reader.nextInt();

      System.out.println("Qual a sua saúde? 1 a 10");
      int saude = reader.nextInt();

      Pessoa pessoa =
          new Pessoa(
              nome,
              altura,
              peso,
              data,
              estadoCivil,
              formacaoAcademica,
              profissao,
              vidaSocial,
              hobby,
              atividadeFisica,
              saude);

      pessoas.add(pessoa);

      System.out.println("Pessoa cadastrada com sucesso!");
    } catch (IllegalArgumentException e) {
      System.err.println("Erro ao cadastrar usuário: : " + e.getMessage());
    }
  }

  public static void listPeople() {
    if (lengthPeople <= 0) {
      System.err.println("Não há pessoas cadastradas.");
      return;
    }

    for (int i = 0; i < lengthPeople; i++) {
      System.out.println(pessoas[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("-------------- BEM VIND@ --------------");
    System.out.println("           CADASTRO DE PESSOA          ");
    System.out.println("---------------------------------------");

    Scanner reader = new Scanner(System.in);
    int choice;

    do {
      choice = menu(reader);
      reader.nextLine();

      switch (choice) {
        case 1:
          registerPerson(reader);
          break;

        case 2:
          listPeople();
          break;

        default:
          break;
      }

    } while (choice != 0);

    reader.close();
  }
}
