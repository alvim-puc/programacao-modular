import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.KNN;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KNNTest {
  private KNN knn;
  private Dataset dataset;

  @BeforeEach
  public void setUp() {
    final Pessoa PESSOA1 = new Pessoa(
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
    final Pessoa PESSOA2 = new Pessoa(
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
    final Pessoa PESSOA3 = new Pessoa(
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
    final Pessoa CLONE_PESSOA1 = new Pessoa(
        "josé",
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
    final Pessoa DIFF_PESSOA1 = new Pessoa(
        "maria",
        1.67f,
        60,
        20000,
        LocalDate.parse("1894-04-02"),
        "Nova Limense",
        Genero.FEMININO,
        EstadoCivil.SOLTEIRO,
        Escolaridade.SUPERIOR,
        Moradia.COM_FAMILIA,
        Hobby.CULINARIA,
        true);

    dataset = new Dataset();
    dataset.addPessoa(DIFF_PESSOA1);
    dataset.addPessoa(CLONE_PESSOA1);
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);

    this.knn = new KNN(dataset, 4);
  }
  
  @Test
  void testClassifyFeliz() {
    boolean result = knn.classifyFeliz(dataset.getPessoaByName("josé"));
    assertTrue(result);
  }
}
