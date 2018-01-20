package com.topomodorodo.alexa.topomodorodo.old.database.pomodoro;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.topomodorodo.alexa.topomodorodo.old.entity.pomodoro.Pomodoro;

import java.util.List;

@Dao
public interface PomodoroDao {
    @Query("SELECT * FROM pomodoro")
    List<Pomodoro> getAll();

    @Query("SELECT * FROM pomodoro WHERE uid IN (:pomodoroIds)")
    List<Pomodoro> loadAllByIds(int[] pomodoroIds);

    @Query("SELECT * FROM pomodoro WHERE pomodoro_name LIKE :first AND "
            + "start_time LIKE :last LIMIT 1")
    Pomodoro findByName(String first, String last);

    @Insert
    void insertAll(Pomodoro... pomodoroes);

    @Delete
    void delete(Pomodoro pomodoro);
}
