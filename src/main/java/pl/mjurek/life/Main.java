package pl.mjurek.life;

import pl.mjurek.life.controller.GameOfLife;
import pl.mjurek.life.view.GamePanel;

public class Main {
  public static void main(String[] args) {
    new GameOfLife(new GamePanel()).play();
  }
}
