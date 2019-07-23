package com.rest.todoRest.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private Task task1 = new Task();
    private Task task2 = new Task();
    private List<Task> tasks = new ArrayList<Task>(){{
        task1.setTaskName("task1");
        task1.setId(0);
        task1.setDone(false);
        task1.setListId(0);
        add(task1);
        task2.setTaskName("task2");
        task2.setId(1);
        task2.setDone(false);
        task2.setListId(1);
        add(task2);
    }};

    @GetMapping
    public List<Task> tasks() {
        return tasks;
    }

    @GetMapping("/{id}")
    public List<Task> getTaskById(@PathVariable Integer id){
        return tasks.stream().filter(tasks -> tasks.getListId() == id)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody Task task) {
        Task taskFromDb = tasks.get(id);
        taskFromDb.setDone(task.isDone());
        taskFromDb.setListId(task.getListId());
        taskFromDb.setId(task.getId());
        taskFromDb.setTaskName(task.getTaskName());
        return taskFromDb;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Integer id){
        tasks.remove(tasks.get(id));
    }
}
