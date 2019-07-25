package com.rest.todoRest.list;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<TasksList> getTasksLists() {
        return listRepository.findAll();
    }

    public TasksList getListById(Integer id) {
        return listRepository.findById(id).orElse(new TasksList());
    }

    public TasksList create(TasksList tasksList) {
        listRepository.save(tasksList);
        return tasksList;
    }
    public void deleteList(Integer id){
        listRepository.deleteById(id);
    }
}
