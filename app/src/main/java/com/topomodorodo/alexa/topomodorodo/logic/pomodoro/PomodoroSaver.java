package com.topomodorodo.alexa.topomodorodo.logic.pomodoro;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.topomodorodo.alexa.topomodorodo.database.pomodoro.PomodoroDatabaseAbstract;

public class PomodoroSaver {
    PomodoroDatabaseAbstract db;

    public PomodoroSaver(Context context) {
        db = Room.databaseBuilder(context, PomodoroDatabaseAbstract.class, "database-name1").build();
    }

    public void save(){

    }
}
