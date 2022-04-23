package se.schjetne.springhtmxtodo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
public class Todo {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @CreationTimestamp
    @NotNull
    private OffsetDateTime created;

    @Column(nullable = false)
    @UpdateTimestamp
    @NotNull
    private OffsetDateTime updated;

    @Column(nullable = false)
    @NotNull
    private String task;

    @Column(nullable = false)
    @NotNull
    private Boolean done = false;

    public Todo() {
        this.task = "";
    }

    public Todo(String task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getUpdated() {
        return updated;
    }

    public Boolean getDone() {
        return done;
    }

    public String getTask() {
        return task;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setTask(String text) {
        this.task = text;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
