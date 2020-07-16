package com.company.schedule.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table(name = "SCHEDULE_LESSON")
@Entity(name = "schedule_Lesson")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = -2195745314940404507L;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @Temporal(TemporalType.TIME)
    @NotNull
    @Column(name = "TIME_", nullable = false)
    protected Date time;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLASSROOM_ID")
    protected Classroom classroom;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    protected Teacher teacher;

    @JoinTable(name = "SCHEDULE_LESSON_GROUP_LINK",
            joinColumns = @JoinColumn(name = "LESSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
    @ManyToMany
    protected List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}