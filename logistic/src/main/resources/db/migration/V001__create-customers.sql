CREATE TABLE customers (
    id bigint not null auto_increment,
    full_name varchar(255) not null,
    email varchar(255) not null,
    whatsapp varchar(20) not null,

    primary key (id)
)