package io.github.eugenezakhno.todolist.service;

import io.github.eugenezakhno.todolist.entity.Note;
import io.github.eugenezakhno.todolist.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private NoteRepository repository;

    @Autowired
    public void setProductRepository(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note getNoteById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void saveNote(Note note) {
        repository.save(note);
    }

    @Override
    public void updateNote(Integer id, String message, boolean done) {
        Note updated = repository.findOne(id);
        updated.setDone(done);
        updated.setMessage(message);
        repository.save(updated);
    }

    @Override
    public void deleteNote(Integer id) {
        repository.delete(id);
    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }
}