package com.topomodorodo.alexa.topomodorodo.database.pomodoro;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.topomodorodo.alexa.topomodorodo.entity.pomodoro.Pomodoro;

@Database(entities = {Pomodoro.class}, version = 1)
public abstract class PomodoroDatabaseAbstract extends RoomDatabase {
    public abstract PomodoroDao pomodoroDao();
}
