package com.company.schedule.web.screens.group;

import com.company.schedule.entity.Lesson;
import com.company.schedule.entity.Student;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Group;

import javax.inject.Inject;

@UiController("schedule_Group.edit")
@UiDescriptor("group-edit.xml")
@EditedEntityContainer("groupDc")
public class GroupEdit extends StandardEditor<Group> {
    @Inject
    private CollectionLoader<Student> studentsDl;
    @Inject
    private CollectionLoader<Lesson> lessonsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        studentsDl.setParameter("group", getEditedEntity());
        lessonsDl.setParameter("group", getEditedEntity());
        getScreenData().loadAll();
    }
    
    
}