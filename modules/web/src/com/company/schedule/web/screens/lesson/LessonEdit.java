package com.company.schedule.web.screens.lesson;

import com.company.schedule.entity.Group;
import com.company.schedule.service.ClassroomOverflowExceptionService;
import com.company.schedule.service.LessonsCollisionControlService;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.table.ContainerTableItems;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Lesson;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Objects;
import java.util.function.Consumer;

@UiController("schedule_Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
@LoadDataBeforeShow
public class LessonEdit extends StandardEditor<Lesson> {
    @Inject
    private Table<Group> groupsTable;
    @Inject
    private ClassroomOverflowExceptionService classroomOverflowExceptionService;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Lesson lesson = getEditedEntity();
        if(lessonsCollisionControlService.isCollision(lesson)){
            String collisionMessage = "Invalid lesson. Collision has been detected";
            notifications.create().withCaption(collisionMessage).withType(Notifications.NotificationType.ERROR).show();
        }
    }

    @Inject
    private LessonsCollisionControlService lessonsCollisionControlService;
//    @Subscribe("groupsTable.add")
//    public void onGroupsTableAdd(Action.ActionPerformedEvent event) {
//        Lesson lesson = getEditedEntity();
//        if (classroomOverflowExceptionService.checkClassroomForOverflow(Objects.requireNonNull(groupsTable.getItems()).size(), lesson)) {
//            String roomOverflowMessage = "The classroom is overflowed. Capacity limit : " + classroomOverflowExceptionService.loadCapacity(lesson);
//            notifications.create().withCaption(roomOverflowMessage).withType(Notifications.NotificationType.ERROR).show();
//        } else {
//        }
//    }


}