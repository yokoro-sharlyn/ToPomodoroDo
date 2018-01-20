package com.topomodorodo.alexa.topomodorodo.old.database.pomodoro;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.topomodorodo.alexa.topomodorodo.old.entity.pomodoro.Pomodoro;

@Database(entities = {Pomodoro.class}, version = 1)
public abstract class PomodoroDatabaseAbstract extends RoomDatabase {
    public abstract PomodoroDao pomodoroDao();
}
