package com.topomodorodo.alexa.topomodorodo.pomodoro;


import com.topomodorodo.alexa.topomodorodo.OnTimeChanged;

import org.jetbrains.annotations.Contract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    private GregorianCalendar calendar = new GregorianCalendar();

    private SimpleDateFormat dateFormatWithoutHours = new SimpleDateFormat("mm:ss", Locale.ENGLISH);
    private SimpleDateFormat dateFormatWithHours = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);

    private OnTimeChanged onTimeChanged;
    private Timer timer;

    PomodoroTimer(OnTimeChanged onTimeChanged) {
        this.onTimeChanged = onTimeChanged;
        updateCalendar(0, 0, 0);
        this.timer = new Timer();
    }

    @Contract(pure = true)
    private TimerTask getTask() {
        return new TimerTask() {
            @Override
            public void run() {
                pomodoroRun();
            }
        };
    }

    void startPomodoro() {
        timer = new Timer();
        timer.schedule(getTask(), 0, 1000);
    }

    void pausePomodoro() {
        timer.cancel();
    }

    public String getTime() {
        return getTimeInString(calendar.getTime());
    }

    void resetPomodoro() {
        timer.purge();
        seconds = 0;
        minutes = 0;
        hours = 0;
        updateCalendar(hours, minutes, seconds);
    }

    private void pomodoroRun() {
        increaseTime();
    }

    private String getTimeInString(Date date) {
        if (hours == 0) {
            return dateFormatWithoutHours.format(date);
        } else {
            return dateFormatWithHours.format(date);
        }
    }

    private void increaseTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        updateCalendar(hours, minutes, seconds);
    }

    private void updateCalendar(int hours, int minutes, int seconds) {
        calendar.set(0, 0, 0, hours, minutes, seconds);
        onTimeChanged.changeTime(getTimeInString(calendar.getTime()));
    }
}
