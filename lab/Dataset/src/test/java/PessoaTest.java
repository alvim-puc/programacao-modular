import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import br.lpm.business.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
  private static Pessoa pessoa;

  @BeforeEach
  void setUp() throws Exception {
    pessoa = new Pessoa();
  }

  @Test
  void testSetAltura() {
    pessoa.setAltura(1.7f);
    assertEquals(1.7f, pessoa.getAltura(), "Testa altura válida");

    pessoa.setAltura(0);
    assertEquals(1.7f, pessoa.getAltura(), "Testa altura abaixo do limite");

    pessoa.setAltura(2.6f);
    assertEquals(1.7f, pessoa.getAltura(), "Testa altura acima do limite");
  }

  @Test
  void testSetDataNascimento() {
    LocalDate testData = LocalDate.now().minusYears(10);
    pessoa.setDataNascimento(testData);
    assertEquals(testData, pessoa.getDataNascimento(), "Testa data válida");

    pessoa.setDataNascimento(LocalDate.now().plusYears(5));
    assertEquals(testData, pessoa.getDataNascimento(), "Testa data inválida");
  }

  @Test
  void testSetNaturalidade() {
    pessoa.setNaturalidade("Salvador");
    assertEquals("Salvador", pessoa.getNaturalidade(), "Testa naturalidade válida");

    pessoa.setNaturalidade("Bah1a");
    assertEquals("Salvador", pessoa.getNaturalidade(), "Testa naturalidade inválida");
  }

  @Test
  void testSetNome() {
    pessoa.setNome("João");
    assertEquals("João", pessoa.getNome(), "Testa nome válido");

    pessoa.setNome("João1");
    assertEquals("João", pessoa.getNome(), "Testa nome inválido");
  }

  @Test
  void testSetPeso() {
    pessoa.setPeso(70);
    assertEquals(70, pessoa.getPeso(), "Testa peso válido");

    pessoa.setPeso(0);
    assertEquals(70, pessoa.getPeso(), "Testa peso abaixo do limite");

    pessoa.setPeso(601);
    assertEquals(70, pessoa.getPeso(), "Testa peso acima do limite");
  }

  @Test
  void testSetRenda() {
    pessoa.setRenda(1000);
    assertEquals(1000, pessoa.getRenda(), "Testa renda válida");

    pessoa.setRenda(0);
    assertEquals(1000, pessoa.getRenda(), "Testa renda inválida");
  }

  @Test
  @DisplayName("Testa idade com base na data de nascimento")
  void testGetIdade() {
    pessoa.setDataNascimento(LocalDate.now().minusYears(18));
    assertEquals(18, pessoa.getIdade(), "Testa idade válida");
  }
}
