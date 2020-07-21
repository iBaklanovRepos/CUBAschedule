package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|room_number")
@Table(name = "SCHEDULE_CLASSROOM")
@Entity(name = "schedule_Classroom")
public class Classroom extends StandardEntity {
    private static final long serialVersionUID = -1337268569439385597L;

    @NotNull
    @Column(name = "ROOM_NUMBER", nullable = false, unique = true, length = 10)
    protected String room_number;

    @NotNull
    @Column(name = "ROOM_TYPE", nullable = false, length = 20)
    protected String room_type;

    @NotNull
    @Column(name = "CAPACITY", nullable = false)
    protected Integer capacity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "classroom")
    protected Lesson lesson;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }
}