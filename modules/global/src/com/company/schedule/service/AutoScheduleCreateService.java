package com.company.schedule.service;

import com.company.schedule.entity.Lesson;

import java.util.Date;
import java.util.List;

public interface AutoScheduleCreateService {
    String NAME = "schedule_AutoScheduleCreateService";
    List<Lesson> createAutoSchedule(Date date);
}