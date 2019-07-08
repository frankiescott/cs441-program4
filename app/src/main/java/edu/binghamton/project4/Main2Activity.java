package edu.binghamton.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

    private int m;
    private int b;
    SeekBar sbm;
    SeekBar sbb;

    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        m = 1;
        b = 1;
        sbm = findViewById(R.id.sbm);
        sbb = findViewById(R.id.sbb);
        drawView = findViewById(R.id.draw_view);

        sbm.setProgress(0);
        sbb.setProgress(0);

        configureSeekBars();
    }

    public void configureSeekBars() {
        sbm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                m = seekBar.getProgress();
                drawView.updateLine(m, b);
            }
        });
        sbb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                b = seekBar.getProgress();
                drawView.updateLine(m, b);
            }
        });
    }
}