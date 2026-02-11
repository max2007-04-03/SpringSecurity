package ua.opnu.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.springsecurity.entity.Note;
import ua.opnu.springsecurity.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new RuntimeException("Note not found");
        }
        noteRepository.save(note);
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
