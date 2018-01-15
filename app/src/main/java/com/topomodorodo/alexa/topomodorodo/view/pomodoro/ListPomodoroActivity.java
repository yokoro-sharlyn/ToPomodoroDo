package com.topomodorodo.alexa.topomodorodo.view.pomodoro;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.database.pomodoro.PomodoroDatabase;
import com.topomodorodo.alexa.topomodorodo.view.pomodoro.adapter.PomodoroAdapter;

public class ListPomodoroActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pomodoro_list);
        PomodoroDatabase pomodoroDatabase = new PomodoroDatabase(getApplicationContext());
        handler = new Handler();
        pomodoroDatabase.savePomodoro("AAAA", "12,3", "AAA");
        recyclerView = findViewById(R.id.pomodoro_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        pomodoroDatabase.getAllPomodoro(pomodoroList ->
                handler.post(() -> recyclerView.setAdapter(new PomodoroAdapter(pomodoroList)))
        );
    }
}
