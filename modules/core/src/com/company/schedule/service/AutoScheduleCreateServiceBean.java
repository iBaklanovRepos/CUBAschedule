package com.company.schedule.service;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Group;
import com.company.schedule.entity.Lesson;
import com.company.schedule.entity.Teacher;
import com.haulmont.bali.datastruct.Tree;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.View;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service(AutoScheduleCreateService.NAME)
public class AutoScheduleCreateServiceBean implements AutoScheduleCreateService {
    @Inject
    private DataManager dataManager;
    @Inject
    private LessonsCollisionControlService lessonsCollisionControlService;
    @Inject
    private Metadata metadata;

    @Override
    public List<Lesson> createAutoSchedule(Date date){
        List<Lesson> newLessons = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Classroom> classrooms = new ArrayList<>();
        List<Group> groups = new ArrayList<>();

        LoadContext<Lesson> lessonContext = LoadContext.create(Lesson.class).setQuery(
                LoadContext.createQuery("select l from schedule_Lesson l " +
                                        "order by l.date").setFirstResult(0).setMaxResults(1))
                .setView(View.LOCAL);
        Lesson firstLesson = dataManager.load(lessonContext);

        LoadContext<Teacher> teacherContext = LoadContext.create(Teacher.class).setQuery(
                LoadContext.createQuery("select t from schedule_Teacher t")).setView(View.LOCAL);
        teachers = dataManager.loadList(teacherContext);

        LoadContext<Classroom> classroomContext = LoadContext.create(Classroom.class).setQuery(
                LoadContext.createQuery("select c from schedule_Classroom c")).setView(View.LOCAL);
        classrooms = dataManager.loadList(classroomContext);

        LoadContext<Group> groupContext = LoadContext.create(Group.class).setQuery(
                LoadContext.createQuery("select g from schedule_Group g")).setView(View.LOCAL);
        groups = dataManager.loadList(groupContext);

        Date firstDay = firstLesson.getDate();
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 8);
        startTime.set(Calendar.MINUTE,30);

        Calendar finishTime = Calendar.getInstance();
        finishTime.set(Calendar.HOUR_OF_DAY, 17);
        finishTime.set(Calendar.MINUTE,30);

        Date currentTime;
        Date currentDay = firstDay;

        while(currentDay.before(date) || currentDay.equals(date)){
//            currentDay.set
            currentTime = startTime.getTime();
            while (currentTime.before(finishTime.getTime()) || currentTime.equals(finishTime.getTime())){
                Lesson newLesson = metadata.create(Lesson.class);
                newLesson.setDate(currentDay);
                newLesson.setTime(currentTime);
                newLesson.setTeacher(getRandomTeacher(teachers));
                newLesson.setClassroom(getRandomClassroom(classrooms));
                newLesson.setGroups(getRandomGroups(groups));

                if(!lessonsCollisionControlService.isCollision(newLesson)){
                    newLessons.add(newLesson);
                }
                currentTime.setTime(currentTime.getTime() + 5400000);
            }
        }

        return newLessons;
    }

    private List<Group> getRandomGroups(List<Group> groups){
        List<Group> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(groups.size()); i++){
            result.add(groups.get(random.nextInt(groups.size())));
        }
        return result;
    }

    private Teacher getRandomTeacher(List<Teacher> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    private Classroom getRandomClassroom(List<Classroom> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

}