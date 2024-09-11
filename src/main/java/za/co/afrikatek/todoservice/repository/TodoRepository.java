package za.co.afrikatek.todoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.afrikatek.todoservice.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
