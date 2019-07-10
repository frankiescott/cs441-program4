package edu.binghamton.project4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

    private float m;
    private float b;
    SeekBar sbm;
    SeekBar sbb;

    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        m = 1;
        b = 0;
        sbm = findViewById(R.id.sbm);
        sbb = findViewById(R.id.sbb);
        drawView = findViewById(R.id.draw_view);

        sbm.setProgress(1);
        sbb.setProgress(10);

        configureSeekBars();
        configureNextButton();
    }

    public void configureNextButton() {
        Button nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                //pass m and b values
                intent.putExtra("m", m);
                intent.putExtra("b", b);
                startActivity(intent);
            }
        });
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
                m = seekBar.getProgress() * .25F;
                drawView.setm(m);
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
                b = seekBar.getProgress() * .25F;
                drawView.setb(b);
            }
        });
    }
}