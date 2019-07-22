package com.rest.todoRest.task;

public class Task {
    private int id;
    private String taskName;
    private int listId;
    private boolean isDone;

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getName() {
        return taskName;
    }

    public int getListId() {
        return listId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.taskName = name;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
