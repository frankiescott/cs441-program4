package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    Paint paint;

    public void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1f);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, 20, 20, paint);
    }
}
