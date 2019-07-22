package com.rest.todoRest.task;

import com.rest.todoRest.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    Task task1 = new Task();
    Task task2 = new Task();
    private List<Task> tasks = new ArrayList<Task>(){{
        task1.setName("task1");
        task1.setId(0);
        task1.setDone(false);
        task1.setListId(0);
        add(task1);
        task2.setName("task2");
        task2.setId(1);
        task2.setDone(false);
        task2.setListId(1);
        add(task2);
    }};

    @GetMapping
    public List<Task> tasks() {
        return tasks;
    }

    @GetMapping("?listId={id}")
    public Task getTaskById(@PathVariable Integer listId){
        return tasks.stream().filter(tasks -> tasks.getListId() == listId)
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
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
        taskFromDb.setName(task.getName());

        return taskFromDb;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Integer id){
        tasks.remove(tasks.get(id));
    }
}
