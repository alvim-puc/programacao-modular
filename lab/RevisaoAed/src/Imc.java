package RevisaoAed.src;

public class Imc {
  private float peso;
  private float altura;

  Imc(float peso, float altura) {
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

  public float getImc() throws IllegalArgumentException {
    if (peso <= 0 || altura <= 0) {
      throw new IllegalArgumentException("O peso e a altura devem ser maiores que 0");
    }

    return peso / (altura * altura);
  }
}
