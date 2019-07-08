package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    //override both constructors
    public DrawView(Context c) { super(c); }
    public DrawView(Context c, AttributeSet s) {
        super(c, s);
    }
    public DrawView(Context c, AttributeSet s, int defStyle) {
        super(c, s, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int maxX = canvas.getWidth();
        int maxY = canvas.getHeight();

        setBackgroundColor(Color.LTGRAY);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3F);
        canvas.drawLine(0, maxY, 200, 200, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = 0;
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);
    }
}
