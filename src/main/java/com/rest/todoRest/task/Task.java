package com.rest.todoRest.task;

import com.rest.todoRest.list.TasksList;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private TasksList tasksList;

    private boolean done;

    private Task(){ }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TasksList getTasksList() {
        return tasksList;
    }

    public void setTasksList(TasksList tasksList) {
        this.tasksList = tasksList;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
