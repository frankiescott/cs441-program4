package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    Paint line_paint;
    Paint axis_paint;
    Paint tick_paint;
    Paint coord_paint;

    int maxX, maxY;
    int width_x, width_y;
    float stopX, stopY;
    float m, b;

    public void init() {
        line_paint = new Paint();
        axis_paint = new Paint();
        tick_paint = new Paint();
        coord_paint = new Paint();

        line_paint.setColor(Color.BLACK);
        line_paint.setStrokeWidth(3F);

        axis_paint.setColor(Color.BLACK);
        axis_paint.setStrokeWidth(4F);

        tick_paint.setColor(Color.BLACK);
        tick_paint.setStrokeWidth(2F);

        coord_paint.setColor(Color.LTGRAY);
        coord_paint.setStrokeWidth(1F);

        m = 1F;
        b = 0;
    }
    //override both constructors
    public DrawView(Context c) {
        super(c);
        init();
    }
    public DrawView(Context c, AttributeSet s) {
        super(c, s);
        init();
    }
    public DrawView(Context c, AttributeSet s, int defStyle) {
        super(c, s, defStyle);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0,canvas.getHeight());
        canvas.scale(1,-1);

        setBackgroundColor(Color.WHITE);

        maxX = canvas.getWidth();
        maxY = canvas.getHeight();
        width_x = maxX / 12; //dividing coordinate plane by 12
        width_y = maxY / 12;

        this.invalidate(); //redraw

        //y axis
        canvas.drawLine(maxX / 2, maxY, maxX / 2, 0, axis_paint);
        //x axis
        canvas.drawLine(0,maxY / 2, maxX, maxY / 2, axis_paint);

        //x axis coordinates
        int start_x = 0;
        for (int i = 0; i <= maxX; ++i) {
            canvas.drawLine(start_x,(maxY / 2) - 10, start_x, (maxY / 2) + 10, tick_paint);
            canvas.drawLine(start_x,0, start_x, maxY, coord_paint);
            start_x += width_x;
        }
        //y axis coordinates
        int start_y = 0;
        for (int i = 0; i <= maxY; ++i) {
            canvas.drawLine((maxX / 2) - 10,start_y, (maxX / 2) + 10, start_y, tick_paint);
            canvas.drawLine(0,start_y, maxX, start_y, coord_paint);
            start_y += width_y;
        }
        stopX = 12 * width_x;
        stopY = (float) (12/m * width_x) + (b * width_x);
        canvas.drawLine(maxX / 2, (maxY / 2) + b * width_y, stopX, stopY, line_paint);
    }

    public void setm(float m) {
        this.m = m;
        this.invalidate();
    }
    public void setb(float b) {
        this.b = b;
        this.invalidate();
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
