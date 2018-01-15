package com.topomodorodo.alexa.topomodorodo.view.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.logic.task.TaskManager;

public class CreateTaskActivity extends AppCompatActivity {
  TaskManager taskManager;
  Button saveTaskButton;
  EditText taskNameEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_task);
    saveTaskButton = findViewById(R.id.save_task_button);
    taskNameEditText = findViewById(R.id.save_task_edit_text);
    taskManager = new TaskManager(getApplicationContext());

    saveTaskButton.setOnClickListener(v -> {
          taskManager.saveTask(taskNameEditText.getText().toString(), "0", "0");
          finish();
        }
    );
  }
}
