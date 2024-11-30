create table if not exists app_user
(
    user_id    uuid default gen_random_uuid() not null primary key,
    email      varchar(255) not null unique,
    password   text,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    phone      varchar(50),
    created_at timestamp,
    updated_at timestamp
);

create table if not exists representative
(
    id          integer not null primary key,
    first_name  varchar(255),
    last_name   varchar(255),
    phonenumber integer,
    rep_type    varchar(255)
);

create table if not exists job
(
    id             varchar(255) not null primary key,
    user_id        uuid,
    install_rep_id     integer,
    constraint fk_install foreign key(install_rep_id) references representative(id),
    sales_rep_id     integer,
    constraint fk_sales foreign key(sales_rep_id) references representative(id),
    email_auth     varchar(255),
    gen_size_model varchar(255),
    install_status text,
    customer_note  text
);