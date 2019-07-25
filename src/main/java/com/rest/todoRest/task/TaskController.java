package com.rest.todoRest.task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/{id}")
    public List<TaskDto> getTaskById(@PathVariable Integer id) {
        return taskService.getTasksByListId(id);
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Integer id){
        taskService.deleteTask(id);
    }
}
