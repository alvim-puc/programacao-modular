package RevisaoAed.src;

import java.util.Scanner;

public class App {
  public static void menu() {
    System.out.println("-------------- MENU --------------");
    System.out.println("1. Fibonacci usando loop");
    System.out.println("2. Fibonacci usando recursão");
    System.out.println("3. Calcular seu IMC");
    System.out.println("4. Sair");
    System.out.print("Opção: ");
  }

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    Integer choice = 0;
    int N;

    do {
      try {
        menu();
        choice = reader.nextInt();

        switch (choice) {
          case 1:
            System.out.print("Digite um numero para calcular seu Fibonacci usando loop: ");
            N = reader.nextInt();
            System.out.println("Resultado: " + RevisaoAed.fibLoop(N));
            break;
          case 2:
            System.out.print("Digite um numero para calcular seu Fibonacci usando recursão: ");
            N = reader.nextInt();
            System.out.println("Resultado: " + RevisaoAed.fibRec(N, 0, 1, 2, 1));
            break;
          case 3:
            System.out.print("Insira seu peso: ");
            float peso = reader.nextFloat();

            System.out.print("Insira sua altura: ");
            float altura = reader.nextFloat();

            Imc imc = new Imc(peso, altura);

            System.out.println(String.format("Seu IMC é: %.2f", imc.getImc()));
            break;
          case 4:
            System.out.println("Goodbye :)");
            break;
          default:
            break;
        }
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }
    } while (choice != 4);

    reader.close();
  }
}
