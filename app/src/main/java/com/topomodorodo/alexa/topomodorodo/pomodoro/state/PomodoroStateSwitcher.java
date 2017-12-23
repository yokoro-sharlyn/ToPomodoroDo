package com.topomodorodo.alexa.topomodorodo.pomodoro.state;


import android.content.Context;

import com.topomodorodo.alexa.topomodorodo.database.PomodoroDatabase;
import com.topomodorodo.alexa.topomodorodo.pomodoro.timer.OnTimeChanged;
import com.topomodorodo.alexa.topomodorodo.pomodoro.timer.PomodoroTimer;

public class PomodoroStateSwitcher {
    private PomodoroTimer pomodoroTimer;
    private PomodoroState state;
    private PomodoroDatabase pomodoroDatabase;
    private PomodoroStatesController pomodoroStatesController;

    public PomodoroStateSwitcher(OnTimeChanged onTimeChanged, OnPomodoroStateChanged onPomodoroStateChanged, Context context) {
        this.pomodoroTimer = new PomodoroTimer(onTimeChanged);
        this.pomodoroStatesController = new PomodoroStatesController(onPomodoroStateChanged);
        this.pomodoroDatabase = new PomodoroDatabase(context);
        changeState(PomodoroState.STOP);
    }

    public void switchPomodoroState() {
        switch (state) {
            case RUN:
                stopPomodoro();
                break;
            case STOP:
                startPomodoro();
                break;
        }
    }

    private void startPomodoro() {
        pomodoroTimer.startPomodoro();
        changeState(PomodoroState.RUN);
    }

    private void stopPomodoro() {
        pomodoroTimer.pausePomodoro();
        changeState(PomodoroState.STOP);
    }

    private void changeState(PomodoroState newState) {
        state = newState;
        pomodoroStatesController.setState(state);
    }

    public void saveState() {
        pomodoroDatabase.savePomodoro("name", "start time", pomodoroTimer.getTime());
        pomodoroTimer.resetPomodoro();
    }

    enum PomodoroState {
        RUN, STOP;
    }
}
