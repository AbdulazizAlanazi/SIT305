package org.deakin.sit305.games;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class GameView extends View{

    private Drawable backgroundImage;

    public GameView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        backgroundImage = context.getResources().getDrawable(
                R.drawable.background);

    }

    @Override
    public void onDraw(Canvas canvas) {
        backgroundImage.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        backgroundImage.draw(canvas);
    }

}
