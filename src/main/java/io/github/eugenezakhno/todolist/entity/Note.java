package io.github.eugenezakhno.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int id;
    private String message;
    private Date date;
    private boolean done;

    public Note() {
    }

    public Note(String message) {
        this.message = message;
        this.date = new Date();
        this.done = false;
    }
}