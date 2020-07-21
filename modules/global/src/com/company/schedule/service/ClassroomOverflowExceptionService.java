package com.company.schedule.service;

import com.company.schedule.entity.Lesson;

public interface ClassroomOverflowExceptionService {
    String NAME = "schedule_ClassroomOverflowExceptionService";

    boolean checkClassroomForOverflow(int curSize, Lesson lesson);
    int loadCapacity(Lesson lesson);
}