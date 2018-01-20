package com.topomodorodo.alexa.topomodorodo.old.view.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.old.logic.task.TaskManager;
import com.topomodorodo.alexa.topomodorodo.old.view.taskinfo.TaskInfoActivity;
import com.topomodorodo.alexa.topomodorodo.old.view.tasklist.adapter.TaskListAdapter;

public class TaskListActivity extends AppCompatActivity {
  RecyclerView taskList;
  TaskManager taskManager;
  FloatingActionButton fab;
  Handler handler;
  TaskListAdapter.OnTaskClickListener onTaskClickListener;

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
        handler.post(() -> taskList.setAdapter(new TaskListAdapter(list, onTaskClickListener)))
    );
  }

  @Override
  protected void onResume() {
    super.onResume();
    taskManager.getAllTasks(list ->
        handler.post(() -> taskList.setAdapter(new TaskListAdapter(list, onTaskClickListener)))
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
      Intent intent = new Intent(TaskListActivity.this, TaskInfoActivity.class);
      Bundle info = new Bundle();
      info.putString("Name", name.getName());
      intent.putExtras(info);
      startActivity(intent);
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
