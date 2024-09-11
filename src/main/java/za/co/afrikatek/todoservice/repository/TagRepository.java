package za.co.afrikatek.todoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.afrikatek.todoservice.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
