package za.co.afrikatek.todoservice.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.co.afrikatek.todoservice.domain.Todo;
import za.co.afrikatek.todoservice.services.TodoService;
import za.co.afrikatek.todoservice.util.PaginationUtil;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoResource {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> findAll(Pageable pageable) {
        log.debug("REST: Request to fetch all todos : {}", pageable);
        Page<Todo> page = todoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        log.debug("REST: Request to fetch todo by id : {}", id);
        Optional<Todo> optionalTodo = todoService.findById(id);
        return optionalTodo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        log.debug("REST: Request to create a todo : {}", todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }

    @PutMapping
    public ResponseEntity<Todo> update(@RequestBody Todo todo) {
        log.debug("REST: Request to update a todo : {}", todo);
        return ResponseEntity.ok(todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("REST: Request to delete a todo with id : {}", id);
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
