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
import za.co.afrikatek.todoservice.domain.Tag;
import za.co.afrikatek.todoservice.services.TagService;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagResource {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<Page<Tag>> getTags(Pageable pageable) {
        log.info("REST: Request to get tags called");
        Page<Tag> tags = tagService.getTags(pageable);
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id) {
        log.info("REST: Request to get tag called : {}", id);
        Optional<Tag> tag = tagService.getTag(id);
        return tag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        log.info("REST: Request to create tag called : {}", tag);
        return ResponseEntity.status(201).body(tagService.createTag(tag));
    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        log.info("REST: Request to update tag called : {}", tag);
        return ResponseEntity.ok(tagService.updateTag(tag.getId(), tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        log.info("REST: Request to delete tag called : {}", id);
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
