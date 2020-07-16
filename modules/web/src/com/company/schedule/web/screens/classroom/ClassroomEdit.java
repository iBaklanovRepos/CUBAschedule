package com.company.schedule.web.screens.classroom;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Classroom;

@UiController("schedule_Classroom.edit")
@UiDescriptor("classroom-edit.xml")
@EditedEntityContainer("classroomDc")
@LoadDataBeforeShow
public class ClassroomEdit extends StandardEditor<Classroom> {
}