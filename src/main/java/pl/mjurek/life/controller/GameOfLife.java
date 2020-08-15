package pl.mjurek.life.controller;

import pl.mjurek.life.model.CellStatus;
import pl.mjurek.life.model.UniverseLogic;
import pl.mjurek.life.view.GamePanel;

public class GameOfLife {
  private final GamePanel gamePanel;

  public GameOfLife(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  public void play() {
    UniverseLogic universe = new UniverseLogic(30);

    int currentGen = 1;
    while (true) {
      sleep();
      CellStatus[][] nextGen = universe.nextGeneration();
      int alive = universe.getGeneration().getNumberOfAlives();

      gamePanel.updateVisuals(currentGen, alive, nextGen);

      currentGen++;
    }
  }

  private void sleep() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
