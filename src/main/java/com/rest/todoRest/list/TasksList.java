package com.rest.todoRest.list;

import javax.persistence.*;

@Entity
@Table(name = "tasks_list")
public class TasksList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "list_name", nullable = false)
    private String listName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
