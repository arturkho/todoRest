package com.rest.todoRest.list;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    public List<TasksList> getTasksLists() {
        return listService.getTasksLists();
    }

    @GetMapping("/{id}")
    public TasksList getListById(@PathVariable Integer id) {
        return listService.getListById(id);
    }

    @PostMapping
    public TasksList create(@RequestBody TasksList tasksList) {
        return listService.create(tasksList);
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Integer id){
        listService.deleteList(id);
    }
}
