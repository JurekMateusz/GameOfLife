package pl.mjurek.life.view;

import pl.mjurek.life.model.CellStatus;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {
  private JPanel statsPanel;
  private JLabel aliveLabel;
  private JLabel generationLabel;
  private LifePanel lifeBoardPanel;

  public GamePanel() {
    super("Game of Life");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setLocationRelativeTo(null);

    initComponents();

    // this should come last
    setVisible(true);
  }

  private void initComponents() {
    setLayout(new BorderLayout());

    statsPanel = new JPanel();
    statsPanel.setName("Stats Panel");

    statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
    add(statsPanel, BorderLayout.PAGE_START);

    generationLabel = new JLabel();
    generationLabel.setName("GenerationLabel");
    generationLabel.setText("Generation #0");
    statsPanel.add(generationLabel);

    aliveLabel = new JLabel();
    aliveLabel.setName("AliveLabel");
    aliveLabel.setText("Alive: 0");
    statsPanel.add(aliveLabel);

    lifeBoardPanel = new LifePanel();
    lifeBoardPanel.setName("Life Board Panel");
    add(lifeBoardPanel, BorderLayout.CENTER);
  }

  public void updateVisuals(int currentGen, int alive, CellStatus[][] nextGen) {
    generationLabel.setText("Generation #" + currentGen);
    generationLabel.repaint();

    aliveLabel.setText("Alive: " + alive);
    aliveLabel.repaint();

    lifeBoardPanel.updateCellArray(nextGen);
    lifeBoardPanel.repaint();
  }
}
