package com.example.yossi.intentservicebasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart,btnStop;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if(v == btnStart)
        {
            intent = new Intent(this,MyIntetntService.class);
            intent.putExtra("counter",20);
            startService(intent);
        }
        else if(v == btnStop)
        {
            stopService(intent);
        }

    }
}
