package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3 , btn4 ,btn5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn_6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer1 = "6분";
                Intent intent = new Intent(MainActivity.this,AlarmActivity.class);
                intent.putExtra("time1",timer1);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.btn_8);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer2= "8분";
                Intent intent = new Intent(MainActivity.this,AlarmActivity2.class);
                intent.putExtra("time2",timer2);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.btn_9);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer3 = "9분";
                Intent intent = new Intent(MainActivity.this,AlarmActivity3.class);
                intent.putExtra("time3",timer3);
                startActivity(intent);
            }
        });

        btn4 = findViewById(R.id.btn_11);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer4 = "11분";
                Intent intent = new Intent(MainActivity.this,AlarmActivity4.class);
                intent.putExtra("time4",timer4);
                startActivity(intent);
            }
        });

        btn5 = findViewById(R.id.btn_13);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timer5 = "13분";
                Intent intent = new Intent(MainActivity.this,AlarmActivity5.class);
                intent.putExtra("time5",timer5);
                startActivity(intent);
            }
        });



    }
}