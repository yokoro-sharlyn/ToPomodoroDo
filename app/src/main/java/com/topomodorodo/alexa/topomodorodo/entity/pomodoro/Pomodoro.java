package com.topomodorodo.alexa.topomodorodo.entity.pomodoro;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pomodoro {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "pomodoro_name")
    private String name;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "time_duration")
    private String timeDuration;

    public Pomodoro(String name, String startTime, String timeDuration) {
        this.name = name;
        this.startTime = startTime;
        this.timeDuration = timeDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
