package io.github.eugenezakhno.todolist.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "test", schema = "test", catalog = "")
public class Note {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    private Date date;
    @Column(name = "done")
    private boolean done;

    public Note() {
    }

    public Note(String message) {
        this.message = message;
        this.date = new Date();
        this.done = false;
    }
}