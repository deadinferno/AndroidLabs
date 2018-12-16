package ru.startandroid.lab02v2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tables extends AppCompatActivity implements View.OnClickListener {


    public String TAG = "dLog";
    public String actName = "[2]Tables";

    Button btn;
    TextView txt;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, actName + "::onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Log.d(TAG, actName + "::findViewById(R.id.button1)");
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(this);

        Log.d(TAG, actName + "::findViewById(R.id.textView1)");
        txt = findViewById(R.id.textView1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, actName + "::onClick()");

        switch (v.getId())
        {
            case R.id.button1:
                Log.d(TAG, actName + "::onClick()::button1");
                prefs = getSharedPreferences("Prefs", MODE_PRIVATE);
                txt.setText(prefs.getString("saved_text", ""));
                Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
