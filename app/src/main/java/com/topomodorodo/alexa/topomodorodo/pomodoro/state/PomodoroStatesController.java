package com.topomodorodo.alexa.topomodorodo.pomodoro.state;


public class PomodoroStatesController {
    private OnPomodoroStateChanged onPomodoroStateChanged;

    public PomodoroStatesController(OnPomodoroStateChanged onPomodoroStateChanged) {
        this.onPomodoroStateChanged = onPomodoroStateChanged;
    }

    public void setState(PomodoroStateSwitcher.PomodoroState state){
        switch (state){
            case STOP:
                onPomodoroStateChanged.stateSwitched("Start");
                break;
            case RUN:
                onPomodoroStateChanged.stateSwitched("Pause");
                break;

        }
    }
}
