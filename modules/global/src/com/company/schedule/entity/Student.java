package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|full_name")
@Table(name = "SCHEDULE_STUDENT")
@Entity(name = "schedule_Student")
public class Student extends StandardEntity {
    private static final long serialVersionUID = -4868034833358718728L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    protected String full_name;

    @NotNull
    @Column(name = "ST_BOOK_NUMBER", nullable = false, unique = true, length = 10)
    protected String st_book_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    protected Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getSt_book_number() {
        return st_book_number;
    }

    public void setSt_book_number(String st_book_number) {
        this.st_book_number = st_book_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}