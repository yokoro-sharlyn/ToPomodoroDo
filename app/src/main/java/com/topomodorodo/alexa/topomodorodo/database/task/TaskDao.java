package com.topomodorodo.alexa.topomodorodo.database.task;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.topomodorodo.alexa.topomodorodo.entity.pomodoro.Pomodoro;
import com.topomodorodo.alexa.topomodorodo.entity.task.Task;

import java.util.List;

@Dao
public interface TaskDao {
  @Query("SELECT * FROM task")
  List<Task> getAll();

  @Query("SELECT * FROM task WHERE uid IN (:taskIds)")
  List<Pomodoro> loadAllByIds(int[] taskIds);

  @Query("SELECT * FROM task WHERE task_name LIKE :first AND "
      + "start_time LIKE :last LIMIT 1")
  Pomodoro findByName(String first, String last);

  @Insert
  void insertAll(Task... tasks);

  @Delete
  void delete(Task task);
}