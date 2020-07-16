package com.company.schedule.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "SCHEDULE_GROUP")
@Entity(name = "schedule_Group")
public class Group extends StandardEntity {
    private static final long serialVersionUID = -2389787330285512191L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, length = 20)
    protected String number;

    @OneToMany(mappedBy = "group")
    protected List<Student> students;
    @JoinTable(name = "SCHEDULE_LESSON_GROUP_LINK",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "LESSON_ID"))
    @ManyToMany
    protected List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}