package za.co.afrikatek.todoservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.afrikatek.todoservice.domain.Todo;
import za.co.afrikatek.todoservice.repository.TodoRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Todo> all = todoRepository.findAll();
        if (all.isEmpty()) {
            Todo todo1 = Todo.builder().name("Read Algorithms beginner").build();
            todoRepository.save(todo1);
            Todo todo2 = Todo.builder().name("Check home decor equipment").build();
            todoRepository.save(todo2);
        }
    }
}
