package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    //override both constructors
    public DrawView(Context c) {
        super(c);
    }
    public DrawView(Context c, AttributeSet s) {
        super(c, s);
    }
    public DrawView(Context c, AttributeSet s, int defStyle) {
        super(c, s, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3F);
        canvas.drawLine(0, 0, 200, 200, paint);
    }
}
