package za.co.afrikatek.todoservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.afrikatek.todoservice.domain.Task;
import za.co.afrikatek.todoservice.repository.TaskRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;

    public Page<Task> findAll(Long todoId, Pageable pageable) {
        log.debug("Find tasks for todo : {} with pageable : {}", todoId, pageable);
        return taskRepository.findByTodoId(todoId, pageable);
    }

    public Optional<Task> findById(Long id) {
        log.debug("Find task with id : {}", id);
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        log.debug("Save task : {}", task);
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        log.debug("Update task : {}", task);
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        log.debug("Delete task with id : {}", id);
        taskRepository.deleteById(id);
    }
}
