package main;

import business.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static ArrayList<Pessoa> pessoas = new ArrayList<>();

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
            choiceEnums = choiceEnums <= 1 || choiceEnums >= 5 ? 1 : choiceEnums;
            EstadoCivil estadoCivil = EstadoCivil.values()[--choiceEnums];

            System.out.println("Qual a sua formação acadêmica? ");
            System.out.println("1. Nenhuma");
            System.out.println("2. Básica");
            System.out.println("3. Média");
            System.out.println("4. Superior");
            System.out.print("Opção: ");
            choiceEnums = reader.nextInt();
            choiceEnums = choiceEnums <= 1 || choiceEnums >= 5 ? 1 : choiceEnums;
            FormacaoAcademica formacaoAcademica = FormacaoAcademica.values()[--choiceEnums];

            System.out.println("Qual a sua profissão? ");
            System.out.println("1. Desempregado");
            System.out.println("2. Estudante");
            System.out.println("3. Autônomo");
            System.out.println("4. CLT");
            System.out.println("5. Empresário");
            System.out.print("Opção: ");
            choiceEnums = reader.nextInt();
            choiceEnums = choiceEnums <= 1 || choiceEnums >= 5 ? 1 : choiceEnums;
            Profissao profissao = Profissao.values()[--choiceEnums];

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

          break;

        case 2:
          if (pessoas.isEmpty()) {
            System.err.println("Não há pessoas cadastradas");
          }

          for (Pessoa p : pessoas) {
            System.out.println(p.toString());
          }
          break;

        default:
          break;
      }

    } while (choice != 0);

    reader.close();
  }
}
