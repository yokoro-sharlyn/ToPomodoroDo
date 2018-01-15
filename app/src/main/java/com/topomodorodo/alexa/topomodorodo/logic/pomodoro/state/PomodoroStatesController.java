package com.topomodorodo.alexa.topomodorodo.logic.pomodoro.state;


public class PomodoroStatesController {
    private OnPomodoroStateChanged onPomodoroStateChanged;
    private PomodoroStateSwitcher.PomodoroTimerState currentState;

    public PomodoroStatesController(OnPomodoroStateChanged onPomodoroStateChanged) {
        this.onPomodoroStateChanged = onPomodoroStateChanged;
    }

    public void setState(PomodoroStateSwitcher.PomodoroTimerState state) {
        currentState = state;
        switch (state) {
            case STOP:
                onPomodoroStateChanged.stateSwitched("Start");
                break;
            case RUN:
                onPomodoroStateChanged.stateSwitched("Pause");
                break;
        }
    }
}
