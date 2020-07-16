-- begin SCHEDULE_STUDENT
alter table SCHEDULE_STUDENT add constraint FK_SCHEDULE_STUDENT_ON_GROUP foreign key (GROUP_ID) references SCHEDULE_GROUP(ID)^
create unique index IDX_SCHEDULE_STUDENT_UNIQ_ST_BOOK_NUMBER on SCHEDULE_STUDENT (ST_BOOK_NUMBER) ^
create index IDX_SCHEDULE_STUDENT_ON_GROUP on SCHEDULE_STUDENT (GROUP_ID)^
-- end SCHEDULE_STUDENT
-- begin SCHEDULE_LESSON
alter table SCHEDULE_LESSON add constraint FK_SCHEDULE_LESSON_ON_CLASSROOM foreign key (CLASSROOM_ID) references SCHEDULE_CLASSROOM(ID)^
alter table SCHEDULE_LESSON add constraint FK_SCHEDULE_LESSON_ON_TEACHER foreign key (TEACHER_ID) references SCHEDULE_TEACHER(ID)^
create index IDX_SCHEDULE_LESSON_ON_CLASSROOM on SCHEDULE_LESSON (CLASSROOM_ID)^
create index IDX_SCHEDULE_LESSON_ON_TEACHER on SCHEDULE_LESSON (TEACHER_ID)^
-- end SCHEDULE_LESSON
-- begin SCHEDULE_CLASSROOM
create unique index IDX_SCHEDULE_CLASSROOM_UNIQ_ROOM_NUMBER on SCHEDULE_CLASSROOM (ROOM_NUMBER) ^
-- end SCHEDULE_CLASSROOM
-- begin SCHEDULE_LESSON_GROUP_LINK
alter table SCHEDULE_LESSON_GROUP_LINK add constraint FK_LESGRO_ON_LESSON foreign key (LESSON_ID) references SCHEDULE_LESSON(ID)^
alter table SCHEDULE_LESSON_GROUP_LINK add constraint FK_LESGRO_ON_GROUP foreign key (GROUP_ID) references SCHEDULE_GROUP(ID)^
-- end SCHEDULE_LESSON_GROUP_LINK
