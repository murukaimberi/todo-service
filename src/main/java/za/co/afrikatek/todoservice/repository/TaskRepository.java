package za.co.afrikatek.todoservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.afrikatek.todoservice.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByTodoId(Long todoId, Pageable pageable);
}
