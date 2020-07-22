package com.company.schedule.web.screens.lesson;

import com.company.schedule.service.AutoScheduleCreateService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Lesson;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.List;

@UiController("schedule_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
    @Inject
    private Button finishScheduleBtn;
    @Inject
    private AutoScheduleCreateService autoScheduleCreateService;
    @Inject
    private GroupTable<Lesson> lessonsTable;

    @Subscribe("finishScheduleBtn")
    public void onFinishScheduleBtnClick(Button.ClickEvent event) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 24);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.YEAR, 2020);
        List<Lesson> lessons = autoScheduleCreateService.createAutoSchedule(calendar.getTime());
        for(Lesson lesson : lessons){
            lessonsTable.addColumn(new Table.Column<>(lesson));
        }
    }
}