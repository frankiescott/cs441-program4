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
        line_paint.setStrokeWidth(4F);

        axis_paint.setColor(Color.BLACK);
        axis_paint.setStrokeWidth(5F);

        tick_paint.setColor(Color.BLACK);
        tick_paint.setStrokeWidth(3F);

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
    public void update(float b) {
        this.b = b;
        this.invalidate();
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
        canvas.drawLine(width_x, maxY, width_x, 0, axis_paint);
        //x axis
        canvas.drawLine(0,width_y, maxX, width_y, axis_paint);

        //x axis coordinates
        int start_x = 0;
        for (int i = 0; i <= maxX; ++i) {
            canvas.drawLine(start_x,(width_y) - 10, start_x, (width_y) + 10, tick_paint);
            canvas.drawLine(start_x,0, start_x, maxY, coord_paint);
            start_x += width_x;
        }
        //y axis coordinates
        int start_y = 0;
        for (int i = 0; i <= maxY; ++i) {
            canvas.drawLine((width_x) - 10,start_y, (width_x) + 10, start_y, tick_paint);
            canvas.drawLine(0,start_y, maxX, start_y, coord_paint);
            start_y += width_y;
        }
        stopX = 12 * width_x;
        stopY = (float) width_x + (m * 4 * width_x) + (b * width_y);
        canvas.drawLine(width_x, width_y + b * width_y, stopX, stopY, line_paint);
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
