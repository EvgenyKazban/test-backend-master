UPDATE budget SET type='Расход' WHERE type='Комиссия';
ALTER TABLE budget ADD author_id INT NULL;
create table author
(
    id      serial primary key,
    fio     text not null,
    created timestamp DEFAULT CURRENT_TIMESTAMP
);