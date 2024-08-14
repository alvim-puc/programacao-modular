package RevisaoAed.src;

public class RevisaoAed {
  public static int fibLoop(int N) {

    if (N < 0) {
      throw new IllegalArgumentException("Não são permitidos números negativos");
    }

    if (N == 0) {
      return 0;
    }

    if (N == 1 || N == 2) {
      return 1;
    }

    /* De acordo com o GJS Guide, cada variável deve ser declarada em sua respectiva linha */
    int a = 0;
    int b = 1;
    int c = a + b;

    /* Em fors, as variaveis podem ser declaradas em sequencia na inicialização, caso necessário */
    for (int i = 1; i < N; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }

  public static int fibRec(int N, int a, int b, int c, int index) {
    if (N < 0) {
      throw new IllegalArgumentException("Não são permitidos números negativos");
    }

    if (N == 1 || N == 2) {
      return 1;
    }

    if (index == N) {
      return b;
    }

    c = a + b;
    a = b;
    b = c;

    index += 1;

    return fibRec(N, a, b, c, index);
  }
}
