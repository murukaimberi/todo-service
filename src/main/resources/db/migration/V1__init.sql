create table if not exists todos
(
    id   bigint       not null primary key auto_increment,
    name varchar(255) not null unique
);
create table if not exists tags
(
    id   bigint       not null primary key auto_increment,
    name varchar(255) not null unique
);
create table if not exists tasks
(
    id          bigint       not null primary key auto_increment,
    title       varchar(150) not null unique,
    description text,
    created_at  timestamp    not null,
    updated_at  timestamp    not null,
    due_date    timestamp,
    start_date  timestamp,
    todo_id     bigint       not null,
    tag_id      bigint,
    constraint foreign key (todo_id) references todos (id),
    constraint foreign key (tag_id) references tags (id)
);