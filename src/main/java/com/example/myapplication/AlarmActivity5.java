package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmActivity5 extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    // 시작버튼
    Button startButton;
    //종료버튼
    Button stopButton;
    CountDownTimer countDownTimer = null;
    TextView timer , success_text;
    long millisUntilFinished;
    long min,sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        startButton = findViewById(R.id.start);
        stopButton = findViewById(R.id.stop);
        timer = findViewById(R.id.timer);
        timer.setText("13:00");
        success_text = findViewById(R.id.success_text);

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    success_text.setText("계란이 삶아지는 중입니다..");
                    startButton.setVisibility(View.INVISIBLE);
                    countDownTimer = new CountDownTimer(780000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            sec = millisUntilFinished / 1000;
                            min = sec / 60;
                            sec = sec % 60;
                            min = min % 60;
                            timer.setText("" + min + ":" + sec);
                        }

                        public void onFinish() {
                            stopButton.setVisibility(View.VISIBLE);
                            timer.setText("완료");
                            success_text.setText("사용자님! 계란이 알맞게 삶아졌습니다.");
                            mediaPlayer = MediaPlayer.create(AlarmActivity5.this, R.raw.alarm);
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    }.start();
                }
            });



        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setText("13:00");
                success_text.setText("");
                stopButton.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        });
    }


    // MediaPlayer는 시스템 리소스를 잡아먹는다.
    // MediaPlayer는 필요이상으로 사용하지 않도록 주의해야
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;
    }
}

