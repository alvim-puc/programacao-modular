import static org.junit.jupiter.api.Assertions.assertTrue;

import br.lpm.business.Dataset;
import br.lpm.business.KNN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KNNTest {
  private KNN knn;
  private Dataset dataset;

  @BeforeEach
  public void SetUp() throws Exception {
    dataset = new Dataset();
    knn = new KNN(dataset, 4);
    dataset.loadDataFromCSV("LPM - Turma 1 - Cadastro de Pessoas.csv");
  }

  @Test
  void testClassifyFeliz() {
    boolean result = knn.classifyFeliz(dataset.getPessoaByName("João Gabriel Pimentel Uzêda Santos"));
    assertTrue(result);
  }
}
