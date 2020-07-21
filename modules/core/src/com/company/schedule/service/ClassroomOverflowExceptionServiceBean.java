package com.company.schedule.service;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Lesson;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service(ClassroomOverflowExceptionService.NAME)
public class ClassroomOverflowExceptionServiceBean implements ClassroomOverflowExceptionService {

    @Inject
    private DataManager dataManager;

    @Override
    public boolean checkClassroomForOverflow(int curSize, Lesson lesson) {
        Optional<Classroom> classroom = loadClassroom(lesson);
        Classroom room = classroom.get();
        int capacity = room.getCapacity();
        return capacity <= curSize;
    }

    @Override
    public int loadCapacity(Lesson lesson){
        Optional<Classroom> classroom = loadClassroom(lesson);
        Classroom room = classroom.get();
        return room.getCapacity();
    }


    private Optional<Classroom> loadClassroom(Lesson lesson) {
        if (lesson.getClassroom() == null) {
            return Optional.empty();
        }
        return Optional.of(dataManager.reload(lesson.getClassroom(), View.LOCAL));
    }
}