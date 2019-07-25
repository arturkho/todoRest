package com.rest.todoRest.task;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

//    public List<TaskDto> getTasks() {
//        return taskRepository.findAll();
//    }

    public List<TaskDto> getTasksByListId(Integer id) {
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskRepository.findAllByTasksListId(id).forEach(t ->{
            TaskDto taskDto = new TaskDto();
            taskDto.setDone(t.isDone());
            taskDto.setListId(t.getTasksList().getId());
            taskDto.setTaskName(t.getTaskName());
            taskDto.setId(t.getId());
            taskDtoList.add(taskDto);
        });
        return taskDtoList;
    }

    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task update(Integer id, Task task) {
        Task taskFromDb = taskRepository.findById(id);
        taskFromDb.setDone(task.isDone());
        taskFromDb.setId(task.getId());
        taskFromDb.setTaskName(task.getTaskName());
        return taskFromDb;
    }
}
