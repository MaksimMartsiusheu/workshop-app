drop table if exists category;

create table category
(
    id        bigint auto_increment,
    name      varchar(255),
    parent_id bigint,
    constraint category_pk
        primary key (id),
    constraint category__id_fk
        foreign key (parent_id) references category
);

drop table if exists product;

create table product
(
    id          bigint auto_increment,
    name        varchar(255) not null,
    price       double,
    category_id bigint      not null,
    constraint product___fk
        foreign key (category_id) references category (id)
);



