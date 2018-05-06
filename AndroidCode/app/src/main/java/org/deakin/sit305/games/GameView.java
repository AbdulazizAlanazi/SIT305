package org.deakin.sit305.games;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements View.OnTouchListener, Runnable {

    private Block[][] blocks;
    private Maze maze;

    private int currentSelectedState = 200;
    private int[] selectedStates;

    private Drawable backgroundImage;
    private Drawable image0;
    private Drawable image1;
    private Drawable image2;
    private Drawable image3;
    private Drawable image4;

    private Drawable image0Selected;
    private Drawable image1Selected;
    private Drawable image2Selected;
    private Drawable image3Selected;
    private Drawable image4Selected;

    private int screenWidth;
    private int screenHeight;
    private int blockWidth;
    private int blockHeight;

    private boolean needIntialisation = true;

    GameEngine engine = new GameEngine();


    public GameView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);

        backgroundImage = context.getResources().getDrawable(
                R.drawable.background);

        image0 = context.getResources().getDrawable(R.drawable.j1);
        image1 = context.getResources().getDrawable(R.drawable.j2);
        image2 = context.getResources().getDrawable(R.drawable.j3);
        image3 = context.getResources().getDrawable(R.drawable.j4);
        image4 = context.getResources().getDrawable(R.drawable.j5);


        image0Selected = context.getResources().getDrawable(R.drawable.b1);
        image1Selected = context.getResources().getDrawable(R.drawable.b2);
        image2Selected = context.getResources().getDrawable(R.drawable.b3);
        image3Selected = context.getResources().getDrawable(R.drawable.b4);
        image4Selected = context.getResources().getDrawable(R.drawable.b5);

        selectedStates = new int[400];
        for (int i = 0; i < 200; i++) {
            selectedStates[i] = 255 - i;
            selectedStates[399 - i] = 255 - i;
        }

    }

    @Override
    public void onDraw(Canvas canvas) {

        if (needIntialisation) {
            initialise(canvas);
            needIntialisation = false;
        }

        backgroundImage.draw(canvas);

        image0Selected.setAlpha(selectedStates[currentSelectedState]);
        image1Selected.setAlpha(selectedStates[currentSelectedState]);
        image2Selected.setAlpha(selectedStates[currentSelectedState]);
        image3Selected.setAlpha(selectedStates[currentSelectedState]);
        image4Selected.setAlpha(selectedStates[currentSelectedState]);

        try {
            for (int row = 0; row < maze.getMaxRows(); row++) {
                for (int col = 0; col < maze.getMaxCols(); col++) {
                    Block block = maze.getBlock(row, col);
                    if (block != null && !block.getSelected()) {
                        displayNormal(canvas, block);
                    } else if (block != null && block.getSelected()) {
                        displaySelected(canvas, block);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Done......");
        }
    }

    private void displaySelected(Canvas canvas, Block block) {

        switch (block.getColor()) {

            case 0:
                image0Selected.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image0Selected.draw(canvas);
                break;
            case 1:
                image1Selected.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image1Selected.draw(canvas);
                break;
            case 2:
                image2Selected.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image2Selected.draw(canvas);
                break;
            case 3:
                image3Selected.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image3Selected.draw(canvas);
                break;
            case 4:
                image4Selected.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image4Selected.draw(canvas);
                break;
        }
    }

    private void displayNormal(Canvas canvas, Block block) {

        switch (block.getColor()) {

            case 0:
                image0.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image0.draw(canvas);
                break;
            case 1:
                image1.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image1.draw(canvas);
                break;
            case 2:
                image2.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image2.draw(canvas);
                break;
            case 3:
                image3.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image3.draw(canvas);
                break;
            case 4:
                image4.setBounds(block.getxLeft(), block.getyTop(),
                        block.getxLeft() + getBlockWidth(), block.getyTop()
                                + getBlockHeight());
                image4.draw(canvas);
                break;

        }
    }


    private void initialise(Canvas canvas) {
        screenWidth = canvas.getWidth();
        screenHeight = canvas.getHeight();

        blockWidth = screenWidth / 10;
        blockHeight = screenHeight / 16;

        backgroundImage.setBounds(0, 0, getScreenWidth(), getScreenHeight());

        engine = new GameEngine();
        engine.start(getBlockWidth(), getBlockHeight());
        maze = engine.getMaze();
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

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            float x = event.getX();
            float y = event.getY();

            x = x / getBlockWidth();
            y = y / getBlockHeight();

            engine.tapped((int)y, (int)x);
            invalidate();
        }
        return true;
    }


    @Override
    public void run() {
        while (true) {

            if (!needIntialisation) {

                currentSelectedState++;
                if (currentSelectedState == selectedStates.length) {
                    currentSelectedState = 0;
                }

                maze.fall((int) (getBlockHeight() * 0.2));
                postInvalidate();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

