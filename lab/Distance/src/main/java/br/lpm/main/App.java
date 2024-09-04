package br.lpm.main;

import br.lpm.business.*;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
  public static final int MAX_PEOPLE = 55;
  public static int lengthPeople = 0;
  public static Pessoa[] pessoas = new Pessoa[MAX_PEOPLE];

  public static int menu(Scanner reader) {
    int choice;

    System.out.println("---------------- MENU -----------------");
    System.out.println("1. Cadastrar uma pessoa");
    System.out.println("2. Listar pessoas cadastradas");
    System.out.println("3. Deletar pessoas cadastradas");
    System.out.println("0. Sair");
    System.out.print("Opção: ");
    choice = reader.nextInt();
    System.out.println("---------------------------------------");

    return choice;
  }

  public static void registerPerson(Scanner reader) {
    if (lengthPeople >= MAX_PEOPLE) {
      System.err.println("Máximo de pessoas cadastradas.");
      return;
    }

    int choiceEnums;

    System.out.print("Digite seu nome: ");
    String nome = reader.nextLine();

    System.out.print("Insira sua altura: ");
    float altura = reader.nextFloat();

    System.out.print("Insira seu peso: ");
    int peso = reader.nextInt();

    System.out.print("Insira sua renda: ");
    float renda = reader.nextFloat();

    reader.nextLine();

    System.out.print("Insira sua data de nascimento no formato AAAA-MM-DD: ");
    String dataNascimento = reader.nextLine();
    LocalDate data = LocalDate.parse(dataNascimento);

    System.out.print("Qual sua naturalidade: ");
    String naturalidade = reader.nextLine();

    System.out.println("Qual o seu gênero? ");
    System.out.println("1. Feminino");
    System.out.println("2. Masculino");
    System.out.println("3. Não-binário");
    System.out.println("4. Não responder");
    System.out.print("Opção: ");
    choiceEnums = reader.nextInt();
    Genero genero =
        Genero.valueOf(
            switch (choiceEnums) {
              case 1 -> Genero.FEMININO.toString();
              case 2 -> Genero.MASCULINO.toString();
              case 3 -> Genero.NAO_BINARIO.toString();
              case 4 -> Genero.NAO_RESPONDER.toString();
              default -> Genero.NAO_RESPONDER.toString();
            });

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

    System.out.println("Qual a sua escolaridade? ");
    System.out.println("1. Nenhuma");
    System.out.println("2. Fundamental");
    System.out.println("3. Médio");
    System.out.println("4. Superior");
    System.out.println("5. Pós-graduação");
    System.out.print("Opção: ");
    choiceEnums = reader.nextInt();
    Escolaridade escolaridade =
        Escolaridade.valueOf(
            switch (choiceEnums) {
              case 1 -> Escolaridade.NENHUMA.toString();
              case 2 -> Escolaridade.FUNDAMENTAL.toString();
              case 3 -> Escolaridade.MEDIO.toString();
              case 4 -> Escolaridade.SUPERIOR.toString();
              case 5 -> Escolaridade.POS_GRADUACAO.toString();
              default -> Escolaridade.NENHUMA.toString();
            });

    System.out.println("Em qual tipo de moradia você reside? ");
    System.out.println("1. Com a família");
    System.out.println("2. Aluguel");
    System.out.println("3. Casa própria");
    System.out.print("Opção: ");
    choiceEnums = reader.nextInt();
    Moradia moradia =
        Moradia.valueOf(
            switch (choiceEnums) {
              case 1 -> Moradia.COM_FAMILIA.toString();
              case 2 -> Moradia.ALUGUEL.toString();
              case 3 -> Moradia.CASA_PROPRIA.toString();
              default -> Moradia.COM_FAMILIA.toString();
            });

    System.out.println("Qual o seu hobby? ");
    System.out.println("1. Arte");
    System.out.println("2. Esporte");
    System.out.println("3. Cinema");
    System.out.println("4. Livro");
    System.out.println("5. Música");
    System.out.println("6. Culinária");
    System.out.println("7. Game");
    System.out.println("8. Nenhum");
    System.out.print("Opção: ");
    choiceEnums = reader.nextInt();
    Hobby hobby =
        Hobby.valueOf(
            switch (choiceEnums) {
              case 1 -> Hobby.ARTE.toString();
              case 2 -> Hobby.ESPORTE.toString();
              case 3 -> Hobby.CINEMA.toString();
              case 4 -> Hobby.LIVRO.toString();
              case 5 -> Hobby.MUSICA.toString();
              case 6 -> Hobby.CULINARIA.toString();
              case 7 -> Hobby.GAME.toString();
              case 8 -> Hobby.NENHUM.toString();
              default -> Hobby.NENHUM.toString();
            });

    System.out.println("Você é feliz? 'true' ou 'false'");
    boolean feliz = reader.nextBoolean();

    Pessoa pessoa =
        new Pessoa(
            nome,
            altura,
            peso,
            renda,
            data,
            naturalidade,
            genero,
            estadoCivil,
            escolaridade,
            moradia,
            hobby,
            feliz);

    pessoas[lengthPeople] = pessoa;
    lengthPeople++;

    System.out.println("Pessoa cadastrada com sucesso!");
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

  public static void deletePeople() {
    pessoas = new Pessoa[MAX_PEOPLE];
    lengthPeople = 0;
    System.out.println("Pessoas deletadas com sucesso.");
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

        case 3:
          deletePeople();
          break;

        default:
          break;
      }

    } while (choice != 0);

    reader.close();
  }
}
