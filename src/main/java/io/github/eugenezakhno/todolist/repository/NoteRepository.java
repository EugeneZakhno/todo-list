package io.github.eugenezakhno.todolist.repository;

import io.github.eugenezakhno.todolist.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}