package za.co.afrikatek.todoservice.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.afrikatek.todoservice.domain.Task;
import za.co.afrikatek.todoservice.services.TaskService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/tasks")
public class TaskResource {
    private final TaskService taskService;

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<Page<Task>> getTasks(@PathVariable("todoId") Long todoId, Pageable pageable) {
        log.info("REST: Request to get all tasks with page : {}, for todo : {}", pageable, todoId);
        return ResponseEntity.ok(taskService.findAll(todoId, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
        log.info("REST: Request to get task with id : {}", id);
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        log.info("REST: Request to create task : {}", task);
        Task createdTask = taskService.save(task);
        return ResponseEntity.status(201).body(createdTask);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        log.info("REST: Request to update task : {}", task);
        Task updatedTask = taskService.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        log.info("REST: Request to delete task with id : {}", id);
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
