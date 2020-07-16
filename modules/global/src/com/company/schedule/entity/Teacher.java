package com.company.schedule.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "SCHEDULE_TEACHER")
@Entity(name = "schedule_Teacher")
public class Teacher extends StandardEntity {
    private static final long serialVersionUID = -6541421753923450989L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    protected String full_name;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "teacher")
    protected Lesson lesson;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}