package za.co.afrikatek.todoservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.afrikatek.todoservice.domain.Todo;
import za.co.afrikatek.todoservice.repository.TodoRepository;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public Page<Todo> findAll(Pageable pageable) {
        log.debug("Request to find all todos by page : {}", pageable);
        return todoRepository.findAll(pageable);
    }

    public Optional<Todo> findById(Long id) {
        log.debug("Request to find todo by id : {}", id);
        return todoRepository.findById(id);
    }

    public Todo create(Todo todo) {
        log.debug("Request to create todo : {}", todo);
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        log.debug("Request to update todo : {}", todo);
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        log.debug("Request to delete todo : {}", id);
        todoRepository.deleteById(id);
    }
}
