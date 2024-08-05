import java.util.Scanner;
import javax.management.InvalidAttributeValueException;

/**
 * @author Bernardo Alvim AKA alvimdev
 * Revisao de AEDs para Lab de Programação Modular
 */
public class RevisaoAed {

  public static int fibLoop(int N) {
    int a = 0, b = 1, c = a + b;

    if (N <= 0) {
      return 0;
    }

    for (int i = 0; i < N; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }

  public static int fibRec(int N, int a, int b, int c, int index) {
    if (N == index) {
      return c;
    }

    c = a + b;
    a = b;
    b = c;

    index += 1;

    return fibRec(N, a, b, c, index);
  }

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    try {
      int N = reader.nextInt();

      System.out.println("Fibonacci usando loop: " + fibLoop(N));

      System.out.println("Fibonacci usando recursão: " + fibRec(N, 0, 1, 0, 0));

      float peso = reader.nextFloat();
      float altura = reader.nextFloat();

      IMC imc = new IMC(peso, altura);

      System.out.println("IMC: " + imc.getImc());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    reader.close();
  }
}

class IMC {
  private float peso;
  private float altura;

  IMC(float peso, float altura) {
    this.peso = peso;
    this.altura = altura;
  }

  public float getAltura() {
    return altura;
  }

  public float getPeso() {
    return peso;
  }

  public void setAltura(float altura) {
    this.altura = altura;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  public float getImc() throws InvalidAttributeValueException {
    if (peso <= 0 || altura <= 0) {
      throw new InvalidAttributeValueException("O peso e a altura devem ser maiores que 0");
    }

    return peso / (altura * altura);
  }
}
