package com.topomodorodo.alexa.topomodorodo.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.pomodoro.state.OnPomodoroStateChanged;
import com.topomodorodo.alexa.topomodorodo.pomodoro.state.PomodoroStateSwitcher;

public class MainActivity extends AppCompatActivity {
    Button startBtn;
    Button saveBtn;
    TextView timeTextView;
    Handler handler;
    PomodoroStateSwitcher pomodoroStateSwitcher;
    OnPomodoroStateChanged onPomodoroStateChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        startBtn.setOnClickListener(view -> pomodoroStateSwitcher.switchPomodoroState());
        saveBtn.setOnClickListener(v -> pomodoroStateSwitcher.saveState());
    }

    private void init() {
        initUIComponents();

        handler = new Handler();
        onPomodoroStateChanged = newState -> startBtn.setText(newState);
        pomodoroStateSwitcher = new PomodoroStateSwitcher(
                newTime -> handler.post(() -> timeTextView.setText(newTime)),
                onPomodoroStateChanged,
                getApplicationContext()
        );
    }

    private void initUIComponents() {
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start);
        saveBtn = findViewById(R.id.save);
        timeTextView = findViewById(R.id.time);
    }
}
