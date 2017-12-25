package com.topomodorodo.alexa.topomodorodo.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.database.Pomodoro;
import com.topomodorodo.alexa.topomodorodo.database.PomodoroDatabase;
import com.topomodorodo.alexa.topomodorodo.pomodoro.state.PomodoroStateSwitcher;
import com.topomodorodo.alexa.topomodorodo.view.adapter.PomodoroAdapter;

import java.util.LinkedList;
import java.util.List;

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
