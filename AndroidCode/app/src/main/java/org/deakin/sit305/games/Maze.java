package org.deakin.sit305.games;

import java.util.Random;

class Maze {

    private Block[][] blocks;
    private int rows = 16, cols = 10;
    private Random random = new Random();

    private int width;
    private int height;


    public void initialiseBlocks() {

        blocks = new Block[rows][cols];

        int xLeft = 0;
        int yTop = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blocks[i][j] = new Block(random.nextInt()%5);
                blocks[i][j].setxLeft(xLeft);
                xLeft = xLeft + width;
            }
            yTop = yTop + height;
            xLeft = 0;
        }
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void assignNeighbours() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (blocks[row][col] != null) {
                    blocks[row][col].setTop(getBlock(row - 1, col));
                    blocks[row][col].setTopRight(getBlock(row - 1, col + 1));
                    blocks[row][col].setRight(getBlock(row, col + 1));
                    blocks[row][col].setBottomRight(getBlock(row + 1, col + 1));
                }
            }
        }
    }

    public int getMaxRows() {
        return rows;
    }

    public int getMaxCols() {
        return cols;
    }

    public Block getBlock(int row, int col) {
        Block returnValue = null;

        if (row >= 0 && row < getMaxRows() && col >= 0 && col < getMaxCols()) {
            returnValue = blocks[row][col];
        }

        return returnValue;
    }

}
