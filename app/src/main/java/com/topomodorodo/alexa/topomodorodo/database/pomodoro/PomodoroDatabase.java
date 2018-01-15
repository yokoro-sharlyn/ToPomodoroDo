package com.topomodorodo.alexa.topomodorodo.database.pomodoro;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.topomodorodo.alexa.topomodorodo.entity.pomodoro.Pomodoro;

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
        new Thread(() -> {
            db.pomodoroDao().insertAll(new Pomodoro(name, startTime, duration));
            for (Pomodoro pomodoro : db.pomodoroDao().getAll()) {
                Log.v("GGGG", "Ggg" + pomodoro.getName() + " " + pomodoro.getTimeDuration());
            }
        }).start();
    }

    public void getAllPomodoro(ResultListener resultListener) {
        new Thread(() -> {
            Log.v("GGGG", "Ggg start");
            List<Pomodoro> pomodoroList = db.pomodoroDao().getAll();
            for (Pomodoro pomodoro : pomodoroList) {
                Log.v("GGGG", "Ggg" + pomodoro.getName() + " " + pomodoro.getTimeDuration());
            }
            resultListener.onResultCalculated(pomodoroList);
        }).start();
    }

    public interface ResultListener {
        void onResultCalculated(List<Pomodoro> pomodoroList);
    }
}
