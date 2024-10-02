package br.lpm.business;

public enum Hobby {
  ARTE(0),
  ESPORTE(1),
  CINEMA(2),
  LIVRO(3),
  MÚSICA(4),
  CULINARIA(5),
  GAME(6),
  NENHUM(7);

  private int value;

  public int getValue() {
    return value;
  }

  private Hobby(int value) {
    this.value = value;
  }

  public static Hobby parseHobby(String hobby) {
    return switch (hobby) {
      case "Arte" -> Hobby.ARTE;
      case "Esporte" -> Hobby.ESPORTE;
      case "Cinema" -> Hobby.CINEMA;
      case "Livro" -> Hobby.LIVRO;
      case "Música" -> Hobby.MÚSICA;
      case "Culinaria" -> Hobby.CULINARIA;
      case "Game" -> Hobby.GAME;
      case "Nenhum" -> Hobby.NENHUM;
      default -> null;
    };
  }
}
