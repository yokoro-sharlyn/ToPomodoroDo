package com.topomodorodo.alexa.topomodorodo.view.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.logic.pomodoro.state.OnPomodoroStateChanged;
import com.topomodorodo.alexa.topomodorodo.logic.pomodoro.state.PomodoroStateSwitcher;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button saveButton;
    Button openListButton;
    TextView timeTextView;
    Handler handler;
    PomodoroStateSwitcher pomodoroStateSwitcher;
    OnPomodoroStateChanged onPomodoroStateChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void initListeners() {
        startButton.setOnClickListener(v -> pomodoroStateSwitcher.switchPomodoroState());
        saveButton.setOnClickListener(v -> pomodoroStateSwitcher.saveState());
        openListButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListPomodoroActivity.class);
            startActivity(intent);
        });
    }

    private void init() {
        initUIComponents();
        initListeners();

        handler = new Handler();
        onPomodoroStateChanged = newState -> startButton.setText(newState);
        pomodoroStateSwitcher = new PomodoroStateSwitcher(
                newTime -> handler.post(() -> timeTextView.setText(newTime)),
                onPomodoroStateChanged,
                getApplicationContext()
        );
    }

    private void initUIComponents() {
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.start);
        saveButton = findViewById(R.id.save);
        timeTextView = findViewById(R.id.time);
        openListButton = findViewById(R.id.open_list_pomodoro_button);
    }
}
