package com.topomodorodo.alexa.topomodorodo.example;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by alexa on 23.12.2017.
 */

public class ExapleUseDB {
    AppDatabase db;

    public ExapleUseDB(Context context) {
         db = Room.databaseBuilder(context, AppDatabase.class, "database-name1").build();
    }

    private void getFromBd() {
        new Thread(() -> {
            db.userDao().insertAll(new User("alex", "top"));
            String firstName = db.userDao().getAll().get(0).getFirstName();
        }).start();
    }
}
