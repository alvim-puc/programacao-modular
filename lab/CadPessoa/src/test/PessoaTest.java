package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import business.EstadoCivil;
import business.FormacaoAcademica;
import business.Pessoa;
import business.Profissao;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
  @Test
  @DisplayName("Testa Altura menor que 0")
  void testSetAlturaNegativa() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setAltura(-8));
  }

  @Test
  @DisplayName("Testa Altura menor que 3 metros")
  void testSetAlturaExcedida() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setAltura(3.1f));
  }

  @Test
  @DisplayName("Testa Altura válida")
  void testSetAlturaValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setAltura(1.5f));
  }

  @Test
  @DisplayName("Testa Atividade fisica menor menor que 0")
  void testSetAtividadeFisicaNegativa() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setAtividadeFisica(-1));
  }

  @Test
  @DisplayName("Testa Atividade fisica menor maior que 7")
  void testSetAtividadeFisicaExcedida() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setAtividadeFisica(8));
  }

  @Test
  @DisplayName("Testa Atividade fisica válida")
  void testSetAtividadeFisicaValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setAtividadeFisica(4));
  }

  @Test
  @DisplayName("Testa Data de Nascimento inválida")
  void testSetDataNascimentoInvalida() {
    Pessoa p = new Pessoa();
    assertThrows(
        IllegalArgumentException.class, () -> p.setDataNascimento(LocalDate.now().plusDays(2)));
  }

  @Test
  @DisplayName("Testa Data de Nascimento válida")
  void testSetDataNascimentoValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setDataNascimento(LocalDate.now().minusYears(10)));
  }

  @Test
  @DisplayName("Testa um estado civil nulo")
  void testSetEstadoCivilNulo() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setEstadoCivil(null));
  }

  @Test
  @DisplayName("Testa um estado civil válido")
  void testSetEstadoCivilValido() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setEstadoCivil(EstadoCivil.SEPARADO));
  }

  @Test
  @DisplayName("Testa uma Formação acadêmica nula")
  void testSetFormacaoAcademicaNula() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setFormacaoAcademica(null));
  }

  @Test
  @DisplayName("Testa uma Formação acadêmica válida")
  void testSetFormacaoAcademicaValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setFormacaoAcademica(FormacaoAcademica.SUPERIOR));
  }

  @Test
  @DisplayName("Testa nome inválido")
  void testSetNomeInvalido() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setNome("Alanz0ka #topOneOfBrazuca"));
  }

  @Test
  void testSetNomeValido() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setNome("Hugo de Paula"));
  }

  @Test
  @DisplayName("Testa um peso maior que 500")
  void testSetPesoExcedido() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setPeso(555));
  }

  @Test
  @DisplayName("Testa um peso menor que 0")
  void testSetPesoNegativo() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setPeso(-7));
  }

  @Test
  @DisplayName("Testa peso válido")
  void testSetPesoValido() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setPeso(70));
  }

  @Test
  @DisplayName("Testa uma profissão nula")
  void testSetProfissaoNula() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setProfissao(null));
  }

  @Test
  @DisplayName("Testa uma profissão válida")
  void testSetProfissaoValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setProfissao(Profissao.CLT));
  }

  @Test
  @DisplayName("Testa saúde menor que 1")
  void testSetSaudeNegativa() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setSaude(0));
  }

  @Test
  @DisplayName("Testa saúde maior que 10")
  void testSetSaudeExcedida() {
    Pessoa p = new Pessoa();
    assertThrows(IllegalArgumentException.class, () -> p.setSaude(15));
  }

  @Test
  @DisplayName("Testa saúde válida")
  void testSetSaudeValida() {
    Pessoa p = new Pessoa();
    assertDoesNotThrow(() -> p.setSaude(5));
  }
}
