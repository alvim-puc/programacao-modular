package RevisaoAed.src;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    try {
      System.out.print("Digite um numero para calcular seu FIbonacci: ");
      int N = reader.nextInt();

      System.out.println("Fibonacci usando loop: " + RevisaoAed.fibLoop(N));

      System.out.println("Fibonacci usando recursão: " + RevisaoAed.fibRec(N, 0, 1, 0, 0));

      System.out.print('\n');

      System.out.print("Insira seu peso: ");
      float peso = reader.nextFloat();

      System.out.print("Insira sua altura: ");
      float altura = reader.nextFloat();

      Imc imc = new Imc(peso, altura);

      System.out.println("IMC: " + imc.getImc());
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }

    reader.close();
  }
}
