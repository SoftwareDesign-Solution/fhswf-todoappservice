package de.fhswf.todoappservice.repository;

import de.fhswf.todoappservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * FROM tasks WHERE (completed = 0)", nativeQuery = true)
    List<Task> findAllOpenTasks();

}
