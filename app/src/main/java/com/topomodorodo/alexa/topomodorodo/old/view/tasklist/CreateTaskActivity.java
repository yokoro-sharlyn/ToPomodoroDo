package com.topomodorodo.alexa.topomodorodo.old.view.tasklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.old.logic.task.TaskManager;

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
