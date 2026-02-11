package ua.opnu.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.opnu.springsecurity.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
