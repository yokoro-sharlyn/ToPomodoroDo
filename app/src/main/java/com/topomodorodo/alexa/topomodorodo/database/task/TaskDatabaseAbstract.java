package com.topomodorodo.alexa.topomodorodo.database.task;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.topomodorodo.alexa.topomodorodo.entity.task.Task;


@Database(entities = {Task.class}, version = 1)
public abstract class TaskDatabaseAbstract extends RoomDatabase {
  public abstract TaskDao taskDao();
}
