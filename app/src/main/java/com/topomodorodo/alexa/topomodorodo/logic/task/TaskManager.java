package com.topomodorodo.alexa.topomodorodo.logic.task;

import android.content.Context;

import com.topomodorodo.alexa.topomodorodo.database.task.TaskDatabase;

public class TaskManager {
  private TaskDatabase taskDatabase;

  public TaskManager(Context context) {
    taskDatabase = new TaskDatabase(context);
  }

  public void saveTask(String name, String startDate, String endDate) {
    taskDatabase.savePomodoro(name, startDate, endDate);
  }//test

  public void getAllTasks(TaskDatabase.ResultListener resultListener){
    taskDatabase.getAllTasks(resultListener);
  }
}
