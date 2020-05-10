package io.github.eugenezakhno.todolist.controllers;

import io.github.eugenezakhno.todolist.entity.Note;
import io.github.eugenezakhno.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class NoteController {

    private NoteService service;
    private String sortDateMethod = "ASC";

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        return "index";
    }


    @GetMapping("/new")
    public String newNote() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String updateNote(@RequestParam String message) {
        service.saveNote(new Note(message));
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Note note = service.getNoteById(id);
        model.addAttribute("note", note);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Integer id, @RequestParam String message,
                           @RequestParam(value = "done", required = false) boolean done) {
        service.updateNote(id, message, done);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteNote(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Note> notebook = filterAndSort();
        model.addAttribute("notes", notebook);
        model.addAttribute("sort", sortDateMethod);
        return "index";
    }

    private List<Note> filterAndSort() {
        List<Note> notebook = null;
        switch (sortDateMethod) {
            case "ASC":
                notebook = service.findAllByOrderByDateAsc();
                break;
            case "DESC":
                notebook = service.findAllByOrderByDateDesc();
                break;
        }
        return notebook;
    }
}