package RevisaoAed.src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import RevisaoAed.src.Imc;

public class ImcTest {
  
  @Test
  @DisplayName("Calcular IMC")
  public void testGetImc() {
    Imc imc = new Imc(68, 1.72f);
    assertEquals(22.99f, imc.getImc(), 1);
  }
}
