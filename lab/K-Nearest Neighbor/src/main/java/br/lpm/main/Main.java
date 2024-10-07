package br.lpm.main;

import br.lpm.business.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Main {
  private static Frame frame = new Frame("Cadastro de Pessoa");
  public static Dataset dataset;
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

  private static String collectString(String attribute) {
    frame.removeAll();

    final String[] value = {""};

    Label label = new Label(attribute);
    label.setBounds(20, 30, 200, 20);

    TextField textField = new TextField();
    textField.setBounds(20, 50, 260, 20);

    Button button = new Button("Enviar");
    button.setBounds(100, 80, 80, 30);

    button.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            value[0] = textField.getText();
            synchronized (frame) {
              frame.notify();
            }
          }
        });

    frame.add(label);
    frame.add(textField);
    frame.add(button);

    frame.setSize(300, 200);
    frame.setLayout(null);
    frame.setVisible(true);

    synchronized (frame) {
      try {
        frame.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return value[0];
  }

  private static boolean collectBoolean(String attribute) {
    frame.removeAll();

    final boolean[] value = {false};

    Label label = new Label(attribute);
    label.setBounds(20, 30, 200, 20);

    Checkbox checkbox = new Checkbox();
    checkbox.setBounds(20, 50, 100, 20);

    Button button = new Button("Enviar");
    button.setBounds(100, 80, 80, 30);

    button.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            value[0] = checkbox.getState();
            synchronized (frame) {
              frame.notify();
            }
          }
        });

    frame.add(label);
    frame.add(checkbox);
    frame.add(button);

    frame.setSize(300, 200);
    frame.setLayout(null);
    frame.setVisible(true);

    synchronized (frame) {
      try {
        frame.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return value[0];
  }

  public static Enum<?> collectEnum(String attribute, Enum<?>[] values) {
    frame.removeAll();

    final Enum<?>[] value = {null};

    Label label = new Label(attribute);
    label.setBounds(20, 30, 200, 20);

    Choice choice = new Choice();
    choice.setBounds(20, 50, 260, 20);

    for (Enum<?> valueEnum : values) {
      choice.add(valueEnum.name());
    }

    Button button = new Button("Enviar");
    button.setBounds(100, 80, 80, 30);

    button.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String selected = choice.getSelectedItem();
            for (Enum<?> valueEnum : values) {
              value[0] = valueEnum.name().equals(selected) ? valueEnum : value[0];
            }
            synchronized (frame) {
              frame.notify();
            }
          }
        });

    frame.add(label);
    frame.add(choice);
    frame.add(button);

    frame.setSize(300, 200);
    frame.setLayout(null);
    frame.setVisible(true);

    synchronized (frame) {
      try {
        frame.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return value[0];
  }

  private static void showMenu() {
    while (true) {
      frame.removeAll();

      final String[] selectedOption = {""};

      Label label = new Label("Selecione uma opção:");
      label.setBounds(20, 30, 150, 20);

      Choice choice = new Choice();
      choice.setBounds(20, 50, 150, 20);
      choice.add("Cadastro");
      choice.add("Busca");
      choice.add("Exclusão");
      choice.add("Similares");
      choice.add("Relatórios");
      choice.add("Sair");

      Button button = new Button("Selecionar");
      button.setBounds(100, 80, 80, 30);

      button.addActionListener(
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              selectedOption[0] = choice.getSelectedItem();
              synchronized (frame) {
                frame.notify();
              }
            }
          });

      frame.add(label);
      frame.add(choice);
      frame.add(button);

      frame.setSize(300, 200);
      frame.setLayout(null);
      frame.setVisible(true);

      synchronized (frame) {
        try {
          frame.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      switch (selectedOption[0]) {
        case "Cadastro" -> realizarCadastro();
        case "Busca" -> realizarBusca();
        case "Exclusão" -> realizarExclusao();
        case "Similares" -> buscarSimilares();
        case "Relatórios" -> gerarRelatorios();
        case "Sair" -> {
          frame.dispose();
          return;
        }
        default -> System.out.println("Opção inválida.");
      }
    }
  }

  private static void realizarCadastro() {
    if (dataset.size() == dataset.getMaxPessoas()) {
      System.err.println("Máximo de pessoas cadastradas");
      return;
    }

    String nome = collectString("Nome:");

    String naturalidade = collectString("Naturalidade:");

    float renda = Float.parseFloat(collectString("Renda:"));

    float altura = Float.parseFloat(collectString("Altura:"));

    int peso = Integer.parseInt(collectString("Peso:"));

    LocalDate dataNascimento = LocalDate.parse(collectString("Data Nascimento: YYYY-MM-DD"));

    Genero genero = (Genero) collectEnum("Gênero:", Genero.values());

    EstadoCivil estadoCivil = (EstadoCivil) collectEnum("Estado Civil:", EstadoCivil.values());

    Escolaridade escolaridade = (Escolaridade) collectEnum("Escolaridade:", Escolaridade.values());

    Moradia moradia = (Moradia) collectEnum("Moradia:", Moradia.values());

    Hobby hobby = (Hobby) collectEnum("Hobby:", Hobby.values());

    boolean feliz = collectBoolean("Feliz:");

    Pessoa pessoa =
        new Pessoa(
            nome,
            altura,
            peso,
            renda,
            dataNascimento,
            naturalidade,
            genero,
            estadoCivil,
            escolaridade,
            moradia,
            hobby,
            feliz);
    System.out.println(pessoa);

    dataset.addPessoa(pessoa);
  }

  private static void realizarBusca() {
    frame.removeAll();

    String nomeBusca = collectString("Nome a ser buscado: ");
    Pessoa pessoa = dataset.getPessoaByName(nomeBusca);

    frame.removeAll();
    if (pessoa == null) {
      printGenericMessage(nomeBusca + " não encontrado.");
    } else {
      printPessoa(pessoa);
    }

    addButtonOK("OK");

    synchronized (frame) {
      try {
        frame.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Busca realizada.");
  }

  private static void realizarExclusao() {
    String nomeExclusao = collectString("Nome a ser excluído: ");
    dataset.removePessoaByName(nomeExclusao);

    printGenericMessage("Pessoa excluída com sucesso.");
    addButtonOK("OK");

    System.out.println("Exclusão realizada.");
  }

  public static void pieHobby() {
    DefaultPieDataset<String> pieDataset = new DefaultPieDataset<>();

    for (Hobby hobby : Hobby.values()) {
      pieDataset.setValue(hobby.toString(), (dataset.percentHobby(hobby) * dataset.size()));
    }

    JFreeChart pieChart =
        ChartFactory.createPieChart("Distribuição dos Hobbies", pieDataset, true, true, false);

    ChartPanel chartPanel = new ChartPanel(pieChart);
    chartPanel.setPreferredSize(new Dimension(800, 600));

    JFrame frame = new JFrame("Distribuição dos Hobbies");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setContentPane(chartPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public static void histogramEscolaridade() {
    DefaultCategoryDataset datasetEscolaridade = new DefaultCategoryDataset();

    for (Escolaridade escolaridade : Escolaridade.values()) {
      datasetEscolaridade.addValue(
          dataset.percentEscolaridade(escolaridade) * dataset.size(),
          "Número de Pessoas",
          escolaridade.toString());
    }

    JFreeChart barChart =
        ChartFactory.createBarChart(
            "Distribuição da Escolaridade",
            "Escolaridade",
            "Número de Pessoas",
            datasetEscolaridade);

    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new Dimension(800, 600));

    JFrame frame = new JFrame("Distribuição da Escolaridade");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setContentPane(chartPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public static void gerarRelatorios() {
    histogramEscolaridade();
    pieHobby();
    System.out.println("Relatório gerado.");
  }

  public static void buscarSimilares() {
    String nomeBusca = collectString("Nome a ser buscado: ");
    Pessoa pessoa = dataset.getPessoaByName(nomeBusca);

    frame.removeAll();
    if (pessoa == null) {
      printGenericMessage(nomeBusca + " não encontrado.");
      addButtonOK("OK");
    } else {
      Pessoa[] similares = dataset.getSimilar(pessoa, 3);
      showNextPerson(similares, 0);
    }
  }

  private static void printPessoa(Pessoa pessoa) {
    Label nomeLabel = new Label("Nome:");
    nomeLabel.setBounds(20, 30, 200, 20);
    Label nomeValueLabel = new Label(pessoa.getNome());
    nomeValueLabel.setBounds(20, 50, 300, 20);

    Label naturalidadeLabel = new Label("Naturalidade:");
    naturalidadeLabel.setBounds(20, 80, 200, 20);
    Label naturalidadeValueLabel = new Label(pessoa.getNaturalidade());
    naturalidadeValueLabel.setBounds(20, 100, 300, 20);

    Label rendaLabel = new Label("Renda:");
    rendaLabel.setBounds(20, 130, 200, 20);
    Label rendaValueLabel = new Label(String.valueOf(pessoa.getRenda()));
    rendaValueLabel.setBounds(20, 150, 300, 20);

    Label alturaLabel = new Label("Altura:");
    alturaLabel.setBounds(20, 180, 200, 20);
    Label alturaValueLabel = new Label(String.valueOf(pessoa.getAltura()));
    alturaValueLabel.setBounds(20, 200, 300, 20);

    Label pesoLabel = new Label("Peso:");
    pesoLabel.setBounds(20, 230, 200, 20);
    Label pesoValueLabel = new Label(String.valueOf(pessoa.getPeso()));
    pesoValueLabel.setBounds(20, 250, 300, 20);

    Label dataNascimentoLabel = new Label("Data de Nascimento:");
    dataNascimentoLabel.setBounds(20, 280, 200, 20);
    Label dataNascimentoValueLabel = new Label(pessoa.getDataNascimento().toString());
    dataNascimentoValueLabel.setBounds(20, 300, 300, 20);

    Label estadoCivilLabel = new Label("Estado Civil:");
    estadoCivilLabel.setBounds(20, 330, 200, 20);
    Label estadoCivilValueLabel = new Label(pessoa.getEstadoCivil().toString());
    estadoCivilValueLabel.setBounds(20, 350, 300, 20);

    Label escolaridadeLabel = new Label("Escolaridade:");
    escolaridadeLabel.setBounds(20, 380, 200, 20);
    Label escolaridadeValueLabel = new Label(pessoa.getEscolaridade().toString());
    escolaridadeValueLabel.setBounds(20, 400, 300, 20);

    Label moradiaLabel = new Label("Moradia:");
    moradiaLabel.setBounds(20, 430, 200, 20);
    Label moradiaValueLabel = new Label(pessoa.getMoradia().toString());
    moradiaValueLabel.setBounds(20, 450, 300, 20);

    frame.add(nomeLabel);
    frame.add(nomeValueLabel);
    frame.add(naturalidadeLabel);
    frame.add(naturalidadeValueLabel);
    frame.add(rendaLabel);
    frame.add(rendaValueLabel);
    frame.add(alturaLabel);
    frame.add(alturaValueLabel);
    frame.add(pesoLabel);
    frame.add(pesoValueLabel);
    frame.add(dataNascimentoLabel);
    frame.add(dataNascimentoValueLabel);
    frame.add(estadoCivilLabel);
    frame.add(estadoCivilValueLabel);
    frame.add(escolaridadeLabel);
    frame.add(escolaridadeValueLabel);
    frame.add(moradiaLabel);
    frame.add(moradiaValueLabel);

    frame.setSize(400, 600);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  private static void showNextPerson(Pessoa[] similares, int current) {
    if (current < similares.length) {
      Pessoa pessoaAtual = similares[current];

      Dialog dialog = new Dialog((Frame) null, "Pessoa Similar", true);
      dialog.setLayout(new BorderLayout());

      Panel panel = new Panel();
      panel.setLayout(new GridLayout(0, 1));

      panel.add(new Label("Nome: " + pessoaAtual.getNome()));
      panel.add(new Label("Naturalidade: " + pessoaAtual.getNaturalidade()));
      panel.add(new Label("Renda: " + pessoaAtual.getRenda()));
      panel.add(new Label("Altura: " + pessoaAtual.getAltura()));
      panel.add(new Label("Peso: " + pessoaAtual.getPeso()));
      panel.add(new Label("Data de Nascimento: " + pessoaAtual.getDataNascimento()));
      panel.add(new Label("Estado Civil: " + pessoaAtual.getEstadoCivil()));
      panel.add(new Label("Escolaridade: " + pessoaAtual.getEscolaridade()));
      panel.add(new Label("Moradia: " + pessoaAtual.getMoradia()));

      dialog.add(panel, BorderLayout.CENTER);

      Button nextButton = new Button("Próximo");
      nextButton.addActionListener(
          e -> {
            dialog.dispose();
            showNextPerson(similares, current + 1);
          });
      dialog.add(nextButton, BorderLayout.SOUTH);

      dialog.setSize(400, 600);
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    } else {
      Dialog dialog = new Dialog((Frame) null, "Mensagem", true);
      dialog.setLayout(new FlowLayout());

      dialog.add(new Label("Fim da lista."));

      Button closeButton = new Button("Fechar");
      closeButton.addActionListener(e -> dialog.dispose());
      dialog.add(closeButton);

      dialog.setSize(300, 150);
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    }
  }

  private static void printGenericMessage(String message) {
    frame.removeAll();
    Label excludedLabel = new Label(message);
    excludedLabel.setBounds(50, 50, 200, 30);
    frame.add(excludedLabel);

    frame.setSize(400, 600);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  public static void addButtonOK(String message) {
    Button okButton = new Button(message);
    okButton.setBounds(100, 500, 80, 30);
    okButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            synchronized (frame) {
              frame.notify();
            }
          }
        });
    frame.add(okButton);
  }

  public static void main(String[] args) {
    dataset = new Dataset();
    dataset.addPessoa(CLONE_PESSOA1);
    dataset.addPessoa(DIFF_PESSOA1);
    dataset.addPessoa(PESSOA1);
    dataset.addPessoa(PESSOA2);
    dataset.addPessoa(PESSOA3);
    showMenu();
  }
}
