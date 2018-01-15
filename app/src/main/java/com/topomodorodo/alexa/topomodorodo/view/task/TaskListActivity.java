package com.topomodorodo.alexa.topomodorodo.view.task;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.logic.task.TaskManager;
import com.topomodorodo.alexa.topomodorodo.view.pomodoro.adapter.PomodoroAdapter;
import com.topomodorodo.alexa.topomodorodo.view.task.adapter.TaskAdapter;

import java.util.LinkedList;

public class TaskListActivity extends AppCompatActivity {
  RecyclerView taskList;
  TaskManager taskManager;
  FloatingActionButton fab;
  Handler handler;
  TaskAdapter.OnTaskClickListener onTaskClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    init();
  }

  private void init() {
    initUI();
    initListeners();
    handler = new Handler();
    taskManager = new TaskManager(getApplicationContext());

    taskManager.getAllTasks(list ->
        handler.post(() -> taskList.setAdapter(new TaskAdapter(list, onTaskClickListener)))
    );
  }

  @Override
  protected void onResume() {
    super.onResume();
    taskManager.getAllTasks(list ->
        handler.post(() -> taskList.setAdapter(new TaskAdapter(list,  onTaskClickListener)))
    );
  }

  private void initUI() {
    setContentView(R.layout.activity_task_list);
    initRecyclerView();
    initToolbar();
    initFunctualButton();
  }

  private void initListeners() {
    fab.setOnClickListener(view -> {
      Intent intent = new Intent(TaskListActivity.this, CreateTaskActivity.class);
      startActivity(intent);
    });

    onTaskClickListener = name -> {

    };
  }

  private void initFunctualButton() {
    fab = findViewById(R.id.fab);
  }

  private void initToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void initRecyclerView() {
    taskList = findViewById(R.id.taskList);
    taskList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
  }
}
