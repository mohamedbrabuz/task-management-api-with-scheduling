package org.netprime.repository;

import org.netprime.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // If endDateTime is set to now + 1 day, it will return all tasks due within the next 24 hours.
    @Query("SELECT t FROM Task t WHERE t.dueDate > current_timestamp " +
            "AND t.dueDate <= :endDateTime AND t.isCompleted = false")
    List<Task> findTasksDueSoon(@Param("endDateTime") LocalDateTime endDateTime);

    @Query("SELECT t FROM Task t WHERE t.dueDate < current_timestamp AND t.isCompleted = false ")
    List<Task> findOverdueTasks();
}
