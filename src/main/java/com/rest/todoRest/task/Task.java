package com.rest.todoRest.task;

public class Task {
    private int id;
    private String taskName;
    private int listId;
    private boolean isDone;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getTaskName() {
        return taskName;
    }

    void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    int getListId() {
        return listId;
    }

    void setListId(int listId) {
        this.listId = listId;
    }

    boolean isDone() {
        return isDone;
    }

    void setDone(boolean done) {
        isDone = done;
    }
}
