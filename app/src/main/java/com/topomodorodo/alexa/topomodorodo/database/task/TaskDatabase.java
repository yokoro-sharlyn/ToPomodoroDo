package com.topomodorodo.alexa.topomodorodo.database.task;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.topomodorodo.alexa.topomodorodo.entity.task.Task;

import java.util.List;

public class TaskDatabase {
  TaskDatabaseAbstract db;

  public TaskDatabase(Context context) {
    db = Room.databaseBuilder(context, TaskDatabaseAbstract.class, "task-name1").build();
  }

  private void getFromBd() {
    new Thread(() -> {
      db.taskDao().insertAll(new Task("alex", "top", "000"));
      String firstName = db.taskDao().getAll().get(0).getName();
    }).start();
  }

  public void savePomodoro(String name, String startTime, String duration) {
    new Thread(() -> {
      db.taskDao().insertAll(new Task(name, startTime, duration));
      for (Task task : db.taskDao().getAll()) {
        Log.v("GGGG", "Ggg" + task.getName() + " " + task.getEndTime());
      }
    }).start();
  }

  public void getAllTasks(ResultListener resultListener) {
    new Thread(() -> {
      List<Task> taskList = db.taskDao().getAll();
      for (Task task : taskList) {
        Log.v("GGGG", "Ggg" + task.getName() + " " + task.getEndTime());
      }
      resultListener.onResultCalculated(taskList);
    }).start();
  }

  public interface ResultListener {
    void onResultCalculated(List<Task> taskList);
  }
}