package com.topomodorodo.alexa.topomodorodo.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.view.adapter.PomodoroAdapter;

import java.util.LinkedList;

public class ListPomodoroActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pomodoro_list);
        recyclerView = findViewById(R.id.pomodoro_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new PomodoroAdapter(new LinkedList<>()));

    }

}
