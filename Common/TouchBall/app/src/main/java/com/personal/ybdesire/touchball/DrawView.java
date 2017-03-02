package com.personal.ybdesire.touchball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by bin_yin on 2017/3/2.
 */
public class DrawView extends View {
    public float currentX = 40;
    public float currentY = 50;

    // create pen
    Paint p = new Paint();

    public  DrawView(Context context){
        super(context);
    }
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setColor(Color.RED); // set pen color
        canvas.drawCircle(currentX, currentY, 15, p);// set a small ball
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        currentX = event.getX();
        currentY = event.getY();
        // re-draw itself
        invalidate();
        return true;
    }

}
