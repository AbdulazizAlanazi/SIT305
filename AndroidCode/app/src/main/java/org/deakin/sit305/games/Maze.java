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
}
