package RevisaoAed.src.tests;

import static org.junit.Assert.assertEquals;

import RevisaoAed.src.RevisaoAed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RevisaoAedTest {
  @Test
  @DisplayName("Testando Fibonacci usando Loop")
  public void testFibLoop() {
    int valTeste = 8;
    assertEquals(21, RevisaoAed.fibLoop(valTeste));
  }

  @Test
  @DisplayName("Testando Fibonacci usando Recursão")
  public void testFIbRec() {
    int valTeste = 5;
    assertEquals(5, RevisaoAed.fibRec(valTeste, 0, 1, 2, 1));
  }
}
