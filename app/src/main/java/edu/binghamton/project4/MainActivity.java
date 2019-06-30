package edu.binghamton.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener {

    RecyclerAdapter adapter;
    TextView topline;
    ArrayList<String> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    }
}
