package com.topomodorodo.alexa.topomodorodo.old.entity.task;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {
  @PrimaryKey(autoGenerate = true)
  private int uid;

  @ColumnInfo(name = "task_name")
  private String name;

  @ColumnInfo(name = "start_time")
  private String startTime;

  @ColumnInfo(name = "end_time")
  private String endTime;

  public Task(String name, String startTime, String endTime) {
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
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

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }
}