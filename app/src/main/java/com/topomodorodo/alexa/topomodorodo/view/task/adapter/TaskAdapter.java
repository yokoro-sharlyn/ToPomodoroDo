package com.topomodorodo.alexa.topomodorodo.view.task.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.entity.task.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
  private List<Task> taskList;
  private OnTaskClickListener listener;

  public TaskAdapter(List<Task> taskList, OnTaskClickListener listener) {
    this.taskList = taskList;
    this.listener = listener;
  }

  @Override
  public TaskAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new TaskViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.task_element, parent, false));
  }

  @Override
  public void onBindViewHolder(TaskAdapter.TaskViewHolder holder, int position) {
    Task task = taskList.get(position);
    holder.name.setText(task.getName());
    holder.time.setText(task.getStartTime());
    holder.end.setText(task.getEndTime());
    holder.setTask(task);
  }

  @Override
  public int getItemCount() {
    return taskList.size();
  }

  class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView name, time, end;
    private Task task;

    TaskViewHolder(View view) {
      super(view);
      view.setOnClickListener(v -> {
        listener.onClick(task.getName());
      });
      name = view.findViewById(R.id.taskName);
      time = view.findViewById(R.id.taskStart);
      end = view.findViewById(R.id.taskEnd);
    }

    public void setTask(Task task) {
      this.task = task;
    }
  }

  public interface OnTaskClickListener {
    void onClick(String name);
  }
}
