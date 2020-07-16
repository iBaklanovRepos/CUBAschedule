-- begin SCHEDULE_GROUP
create table SCHEDULE_GROUP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(20) not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_GROUP
-- begin SCHEDULE_STUDENT
create table SCHEDULE_STUDENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    ST_BOOK_NUMBER varchar(10) not null,
    GROUP_ID varchar(36),
    --
    primary key (ID)
)^
-- end SCHEDULE_STUDENT
-- begin SCHEDULE_LESSON
create table SCHEDULE_LESSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ date not null,
    TIME_ time not null,
    CLASSROOM_ID varchar(36) not null,
    TEACHER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_LESSON
-- begin SCHEDULE_CLASSROOM
create table SCHEDULE_CLASSROOM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ROOM_NUMBER varchar(10) not null,
    ROOM_TYPE varchar(20) not null,
    CAPACITY integer not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_CLASSROOM
-- begin SCHEDULE_TEACHER
create table SCHEDULE_TEACHER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_TEACHER
-- begin SCHEDULE_LESSON_GROUP_LINK
create table SCHEDULE_LESSON_GROUP_LINK (
    LESSON_ID varchar(36) not null,
    GROUP_ID varchar(36) not null,
    primary key (LESSON_ID, GROUP_ID)
)^
-- end SCHEDULE_LESSON_GROUP_LINK
