package com.company.schedule.web.screens.teacher;

import com.company.schedule.entity.Lesson;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Teacher;

import javax.inject.Inject;

@UiController("schedule_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")

public class TeacherEdit extends StandardEditor<Teacher> {
    @Inject
    private CollectionLoader<Lesson> lessonsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        lessonsDl.setParameter("teacher", getEditedEntity());
        getScreenData().loadAll();
    }


}