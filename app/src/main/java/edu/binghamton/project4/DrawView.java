package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    int maxX;
    int maxY;
    int x;
    int y;
    int m;
    int b;

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

        maxX = canvas.getWidth();
        maxY = canvas.getHeight();

        setBackgroundColor(Color.LTGRAY);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3F);

        //y axis
        canvas.drawLine(maxX / 2, maxY, maxX / 2, 0, paint);
        //x axis
        canvas.drawLine(0,maxY / 2, maxX, maxY / 2, paint);

        int width_x = maxX / 12; //dividing coordinate plane by 12
        int width_y = maxY / 12;

        //x axis coordinates
        int start_x = 0;
        for (int i = 0; i <= maxX; ++i) {
            canvas.drawLine(start_x,(maxY / 2) - 10, start_x, (maxY / 2) + 10, paint);
            start_x += width_x;
        }
        //y axis coordinates
        int start_y = 0;
        for (int i = 0; i <= maxY; ++i) {
            canvas.drawLine((maxX / 2) - 10,start_y, (maxX / 2) + 10, start_y, paint);
            start_y += width_y;
        }
        //line
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

    public int calculateY(int m, int b) {
        return (m * 2) + b;
    }
}
