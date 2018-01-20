package com.topomodorodo.alexa.topomodorodo.old.view.tasklist.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.topomodorodo.alexa.topomodorodo.R;
import com.topomodorodo.alexa.topomodorodo.old.entity.task.Task;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
  private List<Task> taskList;
  private OnTaskClickListener listener;

  public TaskListAdapter(List<Task> taskList, OnTaskClickListener listener) {
    this.taskList = taskList;
    this.listener = listener;
  }

  @Override
  public TaskListAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new TaskViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.task_element, parent, false));
  }

  @Override
  public void onBindViewHolder(TaskListAdapter.TaskViewHolder holder, int position) {
    Task task = taskList.get(position);
    holder.name.setText(task.getName());
    holder.time.setText(task.getStartTime());
    holder.end.setText(task.getEndTime());
    holder.itemView.setOnClickListener(v -> listener.onClick(task));
  }

  @Override
  public int getItemCount() {
    return taskList.size();
  }

  class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView name, time, end;

    TaskViewHolder(View view) {
      super(view);
      name = view.findViewById(R.id.taskName);
      time = view.findViewById(R.id.taskStart);
      end = view.findViewById(R.id.taskEnd);
    }
  }

  public interface OnTaskClickListener {
    void onClick(Task name);
  }
}
