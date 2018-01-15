package com.topomodorodo.alexa.topomodorodo.logic.pomodoro.state;


import android.content.Context;

import com.topomodorodo.alexa.topomodorodo.database.pomodoro.PomodoroDatabase;
import com.topomodorodo.alexa.topomodorodo.logic.pomodoro.timer.OnTimeChanged;
import com.topomodorodo.alexa.topomodorodo.logic.pomodoro.timer.PomodoroTimer;

public class PomodoroStateSwitcher {
    private PomodoroTimer pomodoroTimer;
    private PomodoroTimerState state;
    private PomodoroDatabase pomodoroDatabase;
    private PomodoroStatesController pomodoroStatesController;

    public PomodoroStateSwitcher(OnTimeChanged onTimeChanged, OnPomodoroStateChanged onPomodoroStateChanged, Context context) {
        this.pomodoroTimer = new PomodoroTimer(onTimeChanged);
        this.pomodoroStatesController = new PomodoroStatesController(onPomodoroStateChanged);
        this.pomodoroDatabase = new PomodoroDatabase(context);
        changeState(PomodoroTimerState.STOP);
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
        changeState(PomodoroTimerState.RUN);
    }

    private void stopPomodoro() {
        pomodoroTimer.pausePomodoro();
        changeState(PomodoroTimerState.STOP);
    }

    private void changeState(PomodoroTimerState newState) {
        state = newState;
        pomodoroStatesController.setState(state);
    }

    public void saveState() {
        pomodoroDatabase.savePomodoro("name", "start time", pomodoroTimer.getTime());
        pomodoroTimer.resetPomodoro();
    }

    enum PomodoroTimerState {
        RUN, STOP
    }

    enum PomodoroKind {
        PAUSING, WORKING, RELAXATION
    }
}
