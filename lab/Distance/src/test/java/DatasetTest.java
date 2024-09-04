import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import br.lpm.business.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatasetTest {
  private Dataset dataset;
  private static final Pessoa PESSOA1 =
      new Pessoa(
          "jão",
          1.76f,
          70,
          2000,
          LocalDate.parse("1992-04-02"),
          "Diamantino",
          Genero.MASCULINO,
          EstadoCivil.SEPARADO,
          Escolaridade.FUNDAMENTAL,
          Moradia.ALUGUEL,
          Hobby.NENHUM,
          false);
  private static final Pessoa PESSOA2 =
      new Pessoa(
          "paula",
          1.47f,
          59,
          4800.2f,
          LocalDate.parse("1973-02-27"),
          "Flamenguista",
          Genero.FEMININO,
          EstadoCivil.VIUVO,
          Escolaridade.POS_GRADUACAO,
          Moradia.CASA_PROPRIA,
          Hobby.LIVRO,
          true);
  private static final Pessoa PESSOA3 =
      new Pessoa(
          "gilberto",
          1.80f,
          90,
          8000,
          LocalDate.parse("1996-10-15"),
          "Bahiano",
          Genero.MASCULINO,
          EstadoCivil.SEPARADO,
          Escolaridade.POS_GRADUACAO,
          Moradia.CASA_PROPRIA,
          Hobby.ESPORTE,
          true);

  @BeforeEach
  public void setUp() {
    dataset = new Dataset();
  }

  @Test
  void testAddPessoas() {
    dataset.addPessoa(PESSOA1);
    assertEquals(1, dataset.size());

    dataset.addPessoa(null);
    assertEquals(1, dataset.size());

    dataset.addPessoa(PESSOA1);

    dataset.addPessoa(PESSOA2);
    assertEquals(2, dataset.size());

    dataset.addPessoa(PESSOA2);
    assertEquals(2, dataset.size());
  }

  @Test
  void testAvgAltura() {
    float mediaEsperada = (1.47f + 1.76f) / 2;

    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(mediaEsperada, dataset.avgAltura());
  }

  @Test
  void testAvgPeso() {
    float mediaEsperada = (59 + 70) / 2;

    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(mediaEsperada, dataset.avgPeso());
  }

  @Test
  void testGetAll() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    Pessoa[] pessoasEsperadas = {PESSOA1, PESSOA2};
    Pessoa[] pessoasRecebidas = dataset.getAll();

    for (int i = 0; i < pessoasEsperadas.length; i++) {
      assertEquals(pessoasEsperadas[i], pessoasRecebidas[i]);
    }
  }

  @Test
  void testGetPessoaByName() {
    dataset.addPessoa(PESSOA1);

    assertEquals(PESSOA1, dataset.getPessoaByName(PESSOA1.getNome()));
  }

  @Test
  void testMaxAltura() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(PESSOA1.getAltura(), dataset.maxAltura());
  }

  @Test
  void testMaxPeso() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(PESSOA1.getPeso(), dataset.maxPeso());
  }

  @Test
  void testMinAltura() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(PESSOA2.getAltura(), dataset.minAltura());
  }

  @Test
  void testMinPeso() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    assertEquals(PESSOA2.getPeso(), dataset.minPeso());
  }

  @Test
  void testModeEscolaridade() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(Escolaridade.POS_GRADUACAO, dataset.modeEscolaridade());
  }

  @Test
  void testModeEstadoCivil() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(EstadoCivil.SEPARADO, dataset.modeEstadoCivil());
  }

  @Test
  void testModeGenero() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(Genero.MASCULINO, dataset.modeGenero());
  }

  @Test
  void testModeHobby() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(Hobby.ESPORTE, dataset.modeHobby());
  }

  @Test
  void testModeMoradia() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(Moradia.CASA_PROPRIA, dataset.modeMoradia());
  }

  @Test
  void testPercentAdult() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(1, dataset.percentAdult());
  }

  @Test
  void testPercentEscolaridade() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.6f, dataset.percentEscolaridade(Escolaridade.POS_GRADUACAO), 0.1);
  }

  @Test
  void testPercentEstadoCivil() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.3f, dataset.percentEstadoCivil(EstadoCivil.VIUVO), 0.1);
  }

  @Test
  void testPercentFeliz() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.6f, dataset.percentFeliz(), 1);
  }

  @Test
  void testPercentGenero() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.3f, dataset.percentGenero(Genero.FEMININO), 0.1);
  }

  @Test
  void testPercentHobby() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.3f, dataset.percentHobby(Hobby.NENHUM), 0.1);
  }

  @Test
  void testPercentMoradia() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    assertEquals(0.6f, dataset.percentMoradia(Moradia.CASA_PROPRIA), 0.1);
  }

  @Test
  void testRemoveAll() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);
    dataset.removeAll();
    assertEquals(0, dataset.size());
    assertNotEquals(PESSOA2.getNome(), dataset.getPessoaByName(PESSOA2.getNome()));
  }

  @Test
  void testRemovePessoa() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);

    dataset.removePessoa(PESSOA1);
    assertEquals(1, dataset.size());

    dataset.removePessoa(PESSOA3);
    assertEquals(1, dataset.size());
  }

  @Test
  void testRemovePessoaByName() {
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    dataset.removePessoaByName(PESSOA2.getNome());
    assertEquals(1, dataset.size());

    dataset.removePessoaByName(PESSOA1.getNome());
    assertEquals(1, dataset.size());
  }

  @Test
  void testReplacePessoa() {
    dataset.addPessoa(PESSOA1);

    dataset.replacePessoa(PESSOA1, PESSOA3);
    assertNotEquals(PESSOA3, dataset.getPessoaByName(PESSOA1.getNome()));
  }

  @Test
  void testSize() {
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    assertEquals(2, dataset.size());
    dataset.addPessoa(PESSOA3);
    assertEquals(3, dataset.size());
    dataset.addPessoa(PESSOA1);
    assertEquals(3, dataset.size());
  }
}
