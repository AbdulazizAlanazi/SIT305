package org.deakin.sit305.games;

public class GameEngine {
    private Maze maze = new Maze();

    private int lasttappedRow = 99;
    private int lasttappedCol = 99;

    private int score = 0;

    private boolean gameOver = false;

    public boolean isGameOver() {
        return gameOver;
    }

    public void start(int intrinsicWidth, int intrinsicHeight) {
        score = 0;
        maze.initialiseBlocks();
    }

    public void tapped(int row, int col) {

        startSelection(row, col);
        lasttappedCol = col;
        lasttappedRow = row;

    }


    private void startSelection(int row, int col) {
        if (maze.getBlock(row, col) != null) {
            maze.getBlock(row, col).setSelected();
        }
    }


    public Maze getMaze() {
        return maze;
    }
}
