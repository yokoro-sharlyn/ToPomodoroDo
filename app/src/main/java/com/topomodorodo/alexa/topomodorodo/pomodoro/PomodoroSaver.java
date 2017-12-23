package com.topomodorodo.alexa.topomodorodo.pomodoro;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.topomodorodo.alexa.topomodorodo.database.PomodoroDatabaseAbstract;

/**
 * Created by alexa on 18.12.2017.
 */

public class PomodoroSaver {
    PomodoroDatabaseAbstract db;

    public PomodoroSaver(Context context) {
        db = Room.databaseBuilder(context, PomodoroDatabaseAbstract.class, "database-name1").build();

    }

    public void save(){

    }
}
