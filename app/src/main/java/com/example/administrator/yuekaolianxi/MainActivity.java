package com.example.administrator.yuekaolianxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView myView= (MyView) findViewById(R.id.mv);
        myView.setOnClickListener(new MyView.setOnclic() {
            @Override
            public void onclic() {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
            }
        });
    }
}
