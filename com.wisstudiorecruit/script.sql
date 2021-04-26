create table administrator
(
    name     varchar(20) null,
    password varchar(20) null
);

create table tab_user
(
    password          varchar(11)  null,
    name              varchar(20)  null,
    gender            varchar(20)  null,
    major             varchar(20)  null,
    grade             int          null,
    contactNumber     bigint       null,
    skillMastered     varchar(500) null,
    selfIntroduce     varchar(500) null,
    choiceOfDirection varchar(20)  null,
    studentId         bigint       not null,
    constraint tab_user_studentId_uindex
        unique (studentId)
);

alter table tab_user
    add primary key (studentId);


