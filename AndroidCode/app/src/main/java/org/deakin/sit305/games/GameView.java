package org.deakin.sit305.games;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements View.OnTouchListener {

    private Block[][] blocks;
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



        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 10; col++) {
                int color = blocks[row][col].getColor();
                switch (color) {

                    case 0:
                        image0.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
                        image0.draw(canvas);
                        break;
                    case 1:
                        image1.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
                        image1.draw(canvas);
                        break;
                    case 2:
                        image2.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
                        image2.draw(canvas);
                        break;
                    case 3:
                        image3.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
                        image3.draw(canvas);
                        break;
                    case 4:
                        image4.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
                        image4.draw(canvas);
                        break;
                    case 5:
                        image5.setBounds(col*getBlockWidth(),row*getBlockHeight(),(col+1)*getBlockWidth(), (row+1)*getBlockHeight());
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
        maze.initialiseBlocks();
        blocks = maze.getBlocks();
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}

