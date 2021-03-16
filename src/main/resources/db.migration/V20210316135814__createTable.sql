create table address
(
    id      integer not null auto_increment,
    city    varchar(255),
    country varchar(255),
    flat    varchar(255),
    phone   varchar(255),
    region  varchar(255),
    street  varchar(255),
    user_id integer,
    primary key (id)
) engine=InnoDB;
create table card
(
    id      integer          not null auto_increment,
    price   double precision not null,
    user_id integer          not null,
    primary key (id)
) engine=InnoDB;
create table hibernate_sequence
(
    next_val bigint
) engine=InnoDB;

create table orders
(
    id      integer not null auto_increment,
    user_id integer not null,
    primary key (id)
) engine=InnoDB;
create table orders_product
(
    orders_id  integer not null,
    product_id integer not null
) engine=InnoDB;
create table product
(
    id          integer          not null auto_increment,
    brand       varchar(255),
    category    varchar(255),
    color       varchar(255),
    count       integer          not null,
    date        datetime,
    description varchar(255),
    discount    integer          not null,
    image_url   varchar(255),
    name        varchar(255),
    price       double precision not null,
    status      varchar(255),
    type        varchar(255),
    primary key (id)
) engine=InnoDB;
create table product_card
(
    card_id    integer not null,
    product_id integer not null
) engine=InnoDB;
create table size
(
    id    integer not null,
    count integer not null,
    size  integer not null,
    primary key (id)
) engine=InnoDB;
create table size_product
(
    product_id integer not null,
    size_id    integer not null
) engine=InnoDB;
create table user
(
    id          integer not null auto_increment,
    active      bit     not null,
    email       varchar(255),
    gender      varchar(255),
    name        varchar(255),
    password    varchar(255),
    picture_url varchar(255),
    user_role   varchar(255),
    surname     varchar(255),
    token       varchar(255),
    primary key (id)
) engine=InnoDB;
alter table card
    add constraint UK_bghvg4xo76su71a9k40s0rplq unique (user_id);
alter table orders
    add constraint UK_k8kupdtcdpqd57b6j4yq9uvdj unique (user_id);
alter table address
    add constraint FKda8tuywtf0gb6sedwk7la1pgi foreign key (user_id) references user (id);
alter table card
    add constraint FKl4gbym62l738id056y12rt6q6 foreign key (user_id) references user (id);
alter table orders
    add constraint FKel9kyl84ego2otj2accfd8mr7 foreign key (user_id) references user (id);
alter table orders_product
    add constraint FKhqvk1lcdpap9qym2o94b45mcs foreign key (product_id) references product (id);
alter table orders_product
    add constraint FK7h8a805aormf2mxryf70m1n7a foreign key (orders_id) references orders (id);
alter table product_card
    add constraint FKgk4doyiauk5mcdcpq8frefqfi foreign key (product_id) references product (id);
alter table product_card
    add constraint FKldee1ygbnvlt6vyoqmdoijemv foreign key (card_id) references card (id);
alter table size_product
    add constraint FK1cel861ivevbm589o6uyes1h2 foreign key (size_id) references size (id);
alter table size_product
    add constraint FKmnesxf69qwvk7og5n8klp4q9m foreign key (product_id) references product (id)
