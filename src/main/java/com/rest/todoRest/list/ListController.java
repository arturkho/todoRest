package com.rest.todoRest.list;

import com.rest.todoRest.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lists")
public class ListController {
    TasksList list1 = new TasksList();

    private List<TasksList> tasksLists = new ArrayList<TasksList>() {{
        list1.setListName("list1");
        list1.setId(0);
        add(list1);
        list1.setListName("list2");
        list1.setId(0);
        add(list1);
    }};

    @GetMapping
    public List<TasksList> tasksLists() {
        return tasksLists;
    }

    @GetMapping("{id}")
    public TasksList getTasksListById(@PathVariable Integer id) {
        return tasksLists.stream().filter(tasks -> tasks.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
    }

    @PostMapping
    public TasksList create(@RequestBody TasksList tasksList) {

        tasksLists.add(tasksList);

        return tasksList;
    }

    @PutMapping("{id}")
    public TasksList update(@PathVariable Integer id, @RequestBody TasksList tasksList) {
        TasksList listFromDb = tasksLists.get(id);
        listFromDb.setId(tasksList.getId());
        listFromDb.setListName(tasksList.getListName());

        return listFromDb;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable Integer id){
        tasksLists.remove(tasksLists.get(id));
    }
}
