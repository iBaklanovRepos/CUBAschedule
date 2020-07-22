package com.company.schedule.service;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Group;
import com.company.schedule.entity.Lesson;
import com.company.schedule.entity.Teacher;
import com.haulmont.bali.datastruct.Tree;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service(LessonsCollisionControlService.NAME)
public class LessonsCollisionControlServiceBean implements LessonsCollisionControlService {
    @Inject
    private DataManager dataManager;

    @Override
    public boolean isCollision(Lesson lesson){
        Date date = lesson.getDate();
        Date time = lesson.getTime();
        Date endTime = new Date();
        Date startTime = new Date();
        endTime.setTime(time.getTime() + 5340000);
        startTime.setTime(time.getTime() - 5340000);
        Teacher teacher = lesson.getTeacher();
        Classroom classroom = lesson.getClassroom();
        List<Group> groups = lesson.getGroups();
        LoadContext<Lesson> context = LoadContext.create(Lesson.class).setQuery(
                LoadContext.createQuery("select l from schedule_Lesson l " +
                                    "where l.date = :date and " +
                                    "l.time between :starttime and :endtime and " +
                                    "(l.teacher = :teacher or " +
                                    "l.classroom = :classroom or " +
                                    "l.groups in :groups)")
                        .setParameter("date", date)
                        .setParameter("starttime", startTime)
                        .setParameter("endtime", endTime)
                        .setParameter("teacher", teacher)
                        .setParameter("classroom", classroom)
                        .setParameter("groups", groups))
                .setView(View.LOCAL);
        List<Lesson> lessons = dataManager.loadList(context);
        return !lessons.isEmpty();
    }
}