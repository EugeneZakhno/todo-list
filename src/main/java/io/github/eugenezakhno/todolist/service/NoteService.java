package io.github.eugenezakhno.todolist.service;

import io.github.eugenezakhno.todolist.entity.Note;

import java.util.List;

public interface NoteService {
    Note getNoteById(Integer id);

    void updateNote(Integer id, String message, boolean done);
    void deleteNote(Integer id);
    List<Note> findAll();
}