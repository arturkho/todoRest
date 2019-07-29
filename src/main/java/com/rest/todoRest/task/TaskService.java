package com.rest.todoRest.task;

import com.rest.todoRest.list.ListRepository;
import com.rest.todoRest.list.TasksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ListRepository listRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, ListRepository listRepository) {
        this.taskRepository = taskRepository;
        this.listRepository = listRepository;
    }

    public List<TaskDto> getTasksByListId(Integer id) {
        return taskRepository.findAllByTasksListId(id)
                .stream()
                .map(this::fromTaskToDto)
                .collect(Collectors.toList());
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = fromDtoToTask(taskDto);
        Task taskFromDb = taskRepository.save(task);
        return fromTaskToDto(taskFromDb);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public TaskDto update(Integer id, TaskDto taskDto) {
        Task taskFromDb = taskRepository.findById(id).orElse(new Task());
        taskFromDb.setDone(taskDto.isDone());
        taskFromDb.setTaskName(taskDto.getTaskName());
        taskRepository.save(fromDtoToTask(taskDto));
        return taskDto;
    }

    private TaskDto fromTaskToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setDone(task.isDone());
        taskDto.setListId(task.getTasksList().getId());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setId(task.getId());
        return taskDto;
    }

    private Task fromDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setDone(taskDto.isDone());
        task.setTaskName(taskDto.getTaskName());
        task.setId(taskDto.getId());
        task.setTasksList(listRepository.findById(taskDto.getListId()).orElse(new TasksList()));
        return task;

    }
}
