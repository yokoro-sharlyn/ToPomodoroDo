package com.topomodorodo.alexa.topomodorodo.database;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class PomodoroDatabase {
    PomodoroDatabaseAbstract db;

    public PomodoroDatabase(Context context) {
        db = Room.databaseBuilder(context, PomodoroDatabaseAbstract.class, "pomodoro-name1").build();
    }

    private void getFromBd() {
        new Thread(() -> {
            db.pomodoroDao().insertAll(new Pomodoro("alex", "top", "000"));
            String firstName = db.pomodoroDao().getAll().get(0).getName();
            Log.v("GGGG", "Ggg" + firstName);
        }).start();
    }

    public void savePomodoro(String name, String startTime, String duration) {
        new Thread(() -> db.pomodoroDao().insertAll(new Pomodoro(name, startTime, duration))).start();
    }

    public List<Pomodoro> getAllPomodoro() {
        return db.pomodoroDao().getAll();
    }
}
