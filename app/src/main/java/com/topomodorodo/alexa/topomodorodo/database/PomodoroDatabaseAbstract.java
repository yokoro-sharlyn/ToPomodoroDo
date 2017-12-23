package com.topomodorodo.alexa.topomodorodo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Pomodoro.class}, version = 1)
public abstract class PomodoroDatabaseAbstract extends RoomDatabase {
    public abstract PomodoroDao pomodoroDao();
}
