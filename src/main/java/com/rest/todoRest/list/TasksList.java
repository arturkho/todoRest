package com.rest.todoRest.list;

public class TasksList {
    private int id;
    private String taskName;

    public int getId() {
        return id;
    }

    public String getName() {
        return taskName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.taskName = name;
    }
}
