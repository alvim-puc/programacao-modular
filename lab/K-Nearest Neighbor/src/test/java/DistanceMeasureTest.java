import static org.junit.jupiter.api.Assertions.assertEquals;

import br.lpm.business.Dataset;
import br.lpm.business.DistanceMeasure;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistanceMeasureTest {
  private DistanceMeasure distanceMeasure;
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
  private static final Pessoa CLONE_PESSOA1 =
      new Pessoa(
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

  private static final Pessoa DIFF_PESSOA1 =
      new Pessoa(
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

  @BeforeEach
  public void SetUp() {
    dataset = new Dataset();
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(CLONE_PESSOA1);
    dataset.addPessoa(DIFF_PESSOA1);
    distanceMeasure = new DistanceMeasure(dataset);
  }

  @Test
  void testCalcDistance() {
    float distancia = distanceMeasure.calcDistance(PESSOA1, CLONE_PESSOA1);
    assertEquals(
        0, distancia, "Pessoa 1 é idêntica ao seu clone, tirando claro o nome e a naturalidade");

    distancia = distanceMeasure.calcDistance(PESSOA1, DIFF_PESSOA1);
    assertEquals(0.9f, distancia, 0.1);
  }
}
