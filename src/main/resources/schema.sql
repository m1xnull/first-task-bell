create table Position
(
    id   int auto_increment,
    name varchar(30) not null,
    constraint Position_pk
        primary key (id)
);
create unique index Position_name_uindex
    on Position (name);

create table Citizenship
(
    id   int auto_increment,
    name varchar(50) not null,
    code int         not null,
    constraint Citizenship_pk
        primary key (id)
);
create unique index Citizenship_code_uindex
    on Citizenship (code);
create unique index Citizenship_name_uindex
    on Citizenship (name);

create table Document_type
(
    id   int auto_increment,
    name varchar(30) not null,
    code int         not null,
    constraint Document_type_pk
        primary key (id)
);
create unique index Document_type_code_uindex
    on Document_type (code);
create unique index Document_type_name_uindex
    on Document_type (name);

create table Organization
(
    id        int auto_increment,
    name      varchar(30)        not null,
    full_name varchar(60)        not null,
    inn       varchar(12)        not null,
    kpp       varchar(9)         not null,
    address   varchar(60)        not null,
    phone     varchar(20),
    is_active bool default false not null,
    constraint Organization_pk
        primary key (id)
);
create unique index Organization_kpp_uindex
    on Organization (kpp);
create unique index Organization_phone_uindex
    on Organization (phone);
create index Organization_name_index
    on Organization(name);
create index Organization_is_active_index
    on Organization(is_active);

create table Office
(
    id              int auto_increment,
    organization_id int                not null,
    address         varchar(60),
    phone           varchar(20),
    is_active       bool default false not null,
    constraint Office_pk
        primary key (id),
    constraint Office_Organization_id_fk
        foreign key (organization_id) references Organization (id)
);
create unique index Office_address_uindex
    on Office (address);
create unique index Office_phone_uindex
    on Office (phone);
create index Office_is_active_index
    on Office (is_active);

create table User
(
    id             int auto_increment,
    office_id      int         not null,
    citizenship_id int,
    position_id    int         not null,
    first_name     varchar(30) not null,
    second_name    varchar(30),
    last_name      varchar(30),
    phone          varchar(20),
    is_identified  bool default false,
    constraint User_pk
        primary key (id),
    constraint User_Citizenship_id_fk
        foreign key (citizenship_id) references Citizenship (id),
    constraint User_Office_id_fk
        foreign key (office_id) references Office (id),
    constraint User_Position_id_fk
        foreign key (position_id) references Position (id)
);
create unique index User_phone_uindex
    on User (phone);
create index User_first_name_index
    on user (first_name);
create index User_last_name_index
    on user (last_name);
create index User_first_name_and_last_name_index
    on user (first_name, last_name);

create table Document
(
    id               int,
    document_type_id int,
    number           int,
    date             date,
    constraint Document_pk
        primary key (id),
    constraint Document_Document_type_id_fk
        foreign key (document_type_id) references Document_type (id),
    constraint Document_User_id_fk
        foreign key (id) references User (id),
);
create unique index Document_document_type_id_number_uindex
    on Document (document_type_id, number);