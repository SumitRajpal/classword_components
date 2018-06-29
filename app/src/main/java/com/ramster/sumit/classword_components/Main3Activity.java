package com.ramster.sumit.classword_components;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
Intent intent;TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv=(TextView)findViewById(R.id.textt);
        tv.setText(getIntent().getStringExtra("name"));
    }
}
