package org.deakin.sit305.games;

import java.util.Random;

public class Maze {

    private Block[][] blocks;

    private int rows, cols;

    private int[] freeFalls;

    private Random random = new Random();

    private int width;
    private int height;

    public Maze(int rows, int cols, int intrinsicWidth, int intrinsicHeight) {
        this.rows = rows;
        this.cols = cols;
        this.width = intrinsicWidth;
        this.height = intrinsicHeight;

        freeFalls = new int[cols];
        initialiseBlocks(intrinsicWidth, intrinsicHeight);
        assignNeighbours();
    }

    private void initialiseBlocks(int width, int height) {

        blocks = new Block[rows][cols];

        int xLeft = 0;
        int yTop = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blocks[i][j] = new Block(random.nextInt() % 5);
                blocks[i][j].setxLeft(xLeft);
                blocks[i][j].setyTopSettle(yTop);
                xLeft = xLeft + width;
            }
            yTop = yTop + height;
            xLeft = 0;
        }
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


    public void removeAllSelection() {
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxCols(); j++) {
                if (blocks[i][j] != null) {
                    blocks[i][j].clearSelection();
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

    public void fall(int fallBy) {
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxCols(); j++) {
                if (blocks[i][j] != null) {
                    if (!blocks[i][j].getSettled()) {
                        blocks[i][j].setyTop(blocks[i][j].getyTop() + fallBy);
                    }
                }
            }
        }
    }

    public boolean anyPair() {

        boolean returnValue = false;

        for (int i = 0; i < getMaxRows() && (!returnValue); i++) {
            for (int j = 0; j < getMaxCols() && (!returnValue); j++) {
                if (blocks[i][j] != null) {
                    if (blocks[i][j].isSameColorPair()) {
                        returnValue = true;
                    }
                }
            }
        }

        return returnValue;
    }

    public int getSelectionCount() {

        int count = 0;
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxCols(); j++) {
                if (blocks[i][j] != null) {
                    if (blocks[i][j].getSelected()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int deleteSelected() {

        int deleted = 0;

        for (int j = 0; j < getMaxCols(); j++) {
            freeFalls[j] = 0;
            for (int i = 0; i < getMaxRows(); i++) {
                if (blocks[i][j] != null && blocks[i][j].getSelected()) {
                    blocks[i][j] = null;
                    freeFalls[j]++;
                    deleted++;
                }
            }
        }

        return deleted;
    }

    public void addNewBlocksAfterDelete() {

        for (int col = 0; col < getMaxCols(); col++) {
            if (freeFalls[col] > 0) {
                int row = 0;
                for (row = getMaxRows() - 1; row >= 0; row--) {
                    if (getBlock(row, col) == null) {
                        break;
                    }
                }

                blocks[row][col] = new Block(random.nextInt() % 5);
                blocks[row][col].setxLeft(col * width);
                blocks[row][col].setyTopSettle(row * height);

            }
        }
    }

    public void removeNeighbours() {
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxCols(); j++) {
                if (blocks[i][j] != null) {
                    blocks[i][j].setBottom(null);
                    blocks[i][j].setBottomLeft(null);
                    blocks[i][j].setBottomRight(null);
                    blocks[i][j].setLeft(null);
                    blocks[i][j].setRight(null);
                    blocks[i][j].setTop(null);
                    blocks[i][j].setTopLeft(null);
                    blocks[i][j].setTopRight(null);
                }
            }
        }
    }
}
