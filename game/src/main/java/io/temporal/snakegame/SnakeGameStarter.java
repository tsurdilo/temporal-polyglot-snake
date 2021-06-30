package io.temporal.snakegame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeGameStarter {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SnakeGame snakeGame = new SnakeGame();

            snakeGame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    snakeGame.getControllerStub().signal("exitGame");
                    System.exit(0);
                }
            });

            snakeGame.setVisible(true);
        });
    }
}
