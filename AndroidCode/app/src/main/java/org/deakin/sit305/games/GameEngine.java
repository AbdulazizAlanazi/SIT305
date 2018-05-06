package org.deakin.sit305.games;

public class GameEngine {
    private Maze maze;

    private int lasttappedRow = 99;
    private int lasttappedCol = 99;

    private Score score = new Score();

    private boolean gameOver = false;

    public boolean isGameOver() {
        return gameOver;
    }

    public void start(int intrinsicWidth, int intrinsicHeight) {
        maze = new Maze(15, 10, intrinsicWidth, intrinsicHeight);
    }

    public Integer tapped(int row, int col) {

        Integer returnValue = null;

        if (maze.getBlock(row, col) != null) {
            if ((row == lasttappedRow && col == lasttappedCol)
                    || (maze.getBlock(row, col).getSelected())) {
                deleteSelected();
                lasttappedCol = 99;
                lasttappedRow = 99;
            } else {
                startSelection(row, col);
                lasttappedCol = col;
                lasttappedRow = row;
                returnValue = score.getTargetScore();
            }
        }

        return returnValue;
    }

    private void startSelection(int row, int col) {
        maze.removeAllSelection();
        if (maze.getBlock(row, col) != null) {
            maze.getBlock(row, col).setSelected();
        }

        score.setSelectionCount(maze.getSelectionCount());

    }

    private void deleteSelected() {

        maze.deleteSelected();
        maze.addNewBlocksAfterDelete();
        maze.removeNeighbours();
        maze.assignNeighbours();

        score.updateScore();

        if (!maze.anyPair()) {
            gameOver = true;
        }

    }


    public Maze getMaze() {
        return maze;
    }
}
