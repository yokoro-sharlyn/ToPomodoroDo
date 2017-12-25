package com.topomodorodo.alexa.topomodorodo.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.database.Pomodoro;

import java.util.List;

public class PomodoroAdapter extends RecyclerView.Adapter<PomodoroAdapter.PomodoroViewHolder> {
    private List<Pomodoro> pomodoroList;

    public PomodoroAdapter(List<Pomodoro> pomodoroList) {
        this.pomodoroList = pomodoroList;
    }

    @Override
    public PomodoroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PomodoroViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pomodoro_element, parent, false));
    }

    @Override
    public void onBindViewHolder(PomodoroViewHolder holder, int position) {
        Pomodoro pomodoro = pomodoroList.get(position);
        holder.name.setText(pomodoro.getName());
        holder.time.setText(pomodoro.getStartTime());
        holder.duration.setText(pomodoro.getTimeDuration());
    }

    @Override
    public int getItemCount() {
        return pomodoroList.size();
    }

    class PomodoroViewHolder extends RecyclerView.ViewHolder {
        TextView name, time, duration;

        PomodoroViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.pomodoro_name_text_view);
            time = view.findViewById(R.id.pomodoro_time_text_view);
            duration = view.findViewById(R.id.pomodoro_duration_text_view);
        }
    }
}
