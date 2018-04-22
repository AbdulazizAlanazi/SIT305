package org.deakin.sit305.games;

import java.util.Random;

class Maze {

    private int[][] blocks;
    private int rows = 16, cols = 10;
    private Random random = new Random();


    public void initialiseBlocks() {

        blocks = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blocks[i][j] = random.nextInt() % 5;
            }
        }
    }

    public int[][] getBlocks() {
        return blocks;
    }
}
