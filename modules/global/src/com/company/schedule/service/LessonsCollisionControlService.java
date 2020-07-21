package com.company.schedule.service;

import com.company.schedule.entity.Lesson;

public interface LessonsCollisionControlService {
    String NAME = "schedule_LessonsCollisionControlService";
    boolean isCollision(Lesson lesson);
}