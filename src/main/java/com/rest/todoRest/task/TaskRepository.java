package com.rest.todoRest.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTasksListId(int id);

    Task findById(Integer id);

    void deleteById(Integer id);
}
