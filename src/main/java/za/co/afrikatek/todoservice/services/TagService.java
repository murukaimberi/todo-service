package za.co.afrikatek.todoservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.afrikatek.todoservice.domain.Tag;
import za.co.afrikatek.todoservice.repository.TagRepository;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Page<Tag> getTags(Pageable pageable) {
        log.info("Getting all tags");
        return tagRepository.findAll(pageable);
    }

    public Optional<Tag> getTag(Long id) {
        log.info("Getting tag with id {}", id);
        return tagRepository.findById(id);
    }

    public Tag createTag(Tag tag) {
        log.info("Creating new tag {}", tag);
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag tag) {
        log.info("Updating tag with id {}", id);
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (tagOptional.isPresent()) {
            Tag updatedTag = tagOptional.get();
            updatedTag.setName(tag.getName());
            return tagRepository.save(updatedTag);
        }
        return null;
    }

    public void deleteTag(Long id) {
        log.info("Deleting tag with id {}", id);
        tagRepository.deleteById(id);
    }
}
