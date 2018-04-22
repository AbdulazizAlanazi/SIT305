package org.deakin.sit305.games;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class GameView extends View {

    private Maze maze;

    private Drawable backgroundImage;
    private Drawable image0;
    private Drawable image1;
    private Drawable image2;
    private Drawable image3;
    private Drawable image4;
    private Drawable image5;

    private int screenWidth;
    private int screenHeight;
    private int blockWidth;
    private int blockHeight;

    private boolean needIntialisation = true;


    public GameView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        backgroundImage = context.getResources().getDrawable(
                R.drawable.background);

        image0 = context.getResources().getDrawable(R.drawable.b1);
        image1 = context.getResources().getDrawable(R.drawable.b2);
        image2 = context.getResources().getDrawable(R.drawable.b3);
        image3 = context.getResources().getDrawable(R.drawable.b4);
        image4 = context.getResources().getDrawable(R.drawable.b5);
        image5 = context.getResources().getDrawable(R.drawable.b6);

    }

    @Override
    public void onDraw(Canvas canvas) {

        if (needIntialisation) {
            initialise(canvas);
            needIntialisation = false;

        }

        backgroundImage.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        backgroundImage.draw(canvas);


        maze.initialiseBlocks();
        int[][] blocks = maze.getBlocks();

        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 10; col++) {
                int block = blocks[row][col];
                switch (block) {

                    case 0:
                        image0.draw(canvas);
                        break;
                    case 1:
                        image1.draw(canvas);
                        break;
                    case 2:
                        image2.draw(canvas);
                        break;
                    case 3:
                        image3.draw(canvas);
                        break;
                    case 4:
                        image4.draw(canvas);
                        break;
                    case 5:
                        image5.draw(canvas);
                        break;
                }
            }
        }
    }

    private void initialise(Canvas canvas) {
        screenWidth = canvas.getWidth();
        screenHeight = canvas.getHeight();

        blockWidth = screenWidth / 10;
        blockHeight = screenHeight / 16;

        backgroundImage.setBounds(0, 0, getScreenWidth(), getScreenHeight());

        maze = new Maze();
    }

    private int getBlockHeight() {
        return blockHeight;
    }

    private int getBlockWidth() {
        return blockWidth;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}

