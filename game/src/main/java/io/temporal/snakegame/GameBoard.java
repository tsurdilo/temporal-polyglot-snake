package io.temporal.snakegame;

import io.temporal.client.WorkflowClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel implements ActionListener {

    private int appleX;
    private int appleY;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    private GameInfo gameInfo;
    private GameRulesWorkflowInterface boardRulesWorkflow;

    public GameBoard(GameInfo gameInfo, GameRulesWorkflowInterface boardRulesWorkflow) {
        this.gameInfo = gameInfo;
        this.boardRulesWorkflow = boardRulesWorkflow;
        WorkflowClient.start(this.boardRulesWorkflow::exec, gameInfo.getAllDots(), gameInfo.getDotSize());

        initGameBoard();
    }

    private void initGameBoard() {

        addKeyListener(new GameKeyAdapter());
        setBackground(Color.black);
        setFocusable(gameInfo.isFocusable());

        setPreferredSize(new Dimension(gameInfo.getBWidth(), gameInfo.getBHeight()));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon(gameInfo.getDotImg());
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(gameInfo.getAppleImg());
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon(gameInfo.getHeadImg());
        head = iih.getImage();
    }

    private void initGame() {
        boardRulesWorkflow.init();
        //boardRulesStub.signal("init");

        locateApple();

        timer = new Timer(gameInfo.getDelay(), this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon img = new ImageIcon(gameInfo.getTemporalImg());
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            int dots = boardRulesWorkflow.getDots();//zboardRulesStub.query("getDots", int.class);
            int[] x = boardRulesWorkflow.getX();//boardRulesStub.query("getX", int[].class);
            int[] y = boardRulesWorkflow.getY(); //boardRulesStub.query("getY", int[].class);
            g.drawImage(apple, appleX, appleY, this);
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String msg = gameInfo.getGameOverMessage();
        Font small = new Font(gameInfo.getFontName(), Font.BOLD, gameInfo.getFontSize());
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (gameInfo.getBWidth() - metr.stringWidth(msg)) / 2, gameInfo.getBHeight() / 2);

        boardRulesWorkflow.exitGame();
        //this.boardRulesStub.signal("exitGame");
    }

    private void locateApple() {

        int r = (int) (Math.random() * gameInfo.getRandPos());
        appleX = ((r * gameInfo.getDotSize()));

        r = (int) (Math.random() * gameInfo.getRandPos());
        appleY = ((r * gameInfo.getDotSize()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private void move() {
        boardRulesWorkflow.move();

        if (leftDirection) {
            boardRulesWorkflow.moveLeft();
        }

        if (rightDirection) {
            boardRulesWorkflow.moveRight();
        }

        if (upDirection) {
            boardRulesWorkflow.moveUp();
        }

        if (downDirection) {
            boardRulesWorkflow.moveDown();
        }
    }

    private void checkApple() {
        if ((boardRulesWorkflow.getX()[0] == appleX) && (boardRulesWorkflow.getY()[0] == appleY)) {
            boardRulesWorkflow.addDot();
            locateApple();
        }
    }

    private void checkCollision() {
        int dots = boardRulesWorkflow.getDots();
        int[] x = boardRulesWorkflow.getX();
        int[] y = boardRulesWorkflow.getY();

        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= gameInfo.getBHeight()) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= gameInfo.getBWidth()) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private class GameKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

}
