CREATE TABLE deliveries(
    id bigint not null auto_increment,
    customer_id bigint not null,
    tax decimal(10,2) not null,
    status varchar (20) not null,
    ordered_at datetime not null,
    completed_at datetime,

    recipient_name varchar(255) not null,
    recipient_number varchar(30) not null,
    recipient_street varchar(30) not null,
    recipient_neighborhood varchar(30) not null,

    primary key(id)

);

ALTER TABLE deliveries ADD CONSTRAINT fk_delivery_customer FOREIGN KEY (customer_id) references customers (id);