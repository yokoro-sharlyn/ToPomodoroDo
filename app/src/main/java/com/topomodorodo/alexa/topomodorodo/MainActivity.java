package com.topomodorodo.alexa.topomodorodo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    TextView time;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start);
        time = findViewById(R.id.time);
        time.setText("00:00");
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            int seconds = 0;
            int minutes = 0;
            int hours = 0;
            Date timeIntimer = new Date();
            Handler handler = new Handler();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("mm:ss");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

            @Override
            public void run() {
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }
                timeIntimer.setMinutes(minutes);
                timeIntimer.setSeconds(seconds);
                timeIntimer.setHours(hours);
                if (hours == 0) handler.post(() -> time.setText(dateFormat1.format(timeIntimer)));
                else handler.post(() -> time.setText(dateFormat2.format(timeIntimer)));
            }
        }, 0, 1000);
    }


}
