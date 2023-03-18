CREATE TABLE occurrences(
    id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    created_at datetime not null,

    primary key (id)
);

ALTER TABLE occurrences ADD CONSTRAINT fk_delivery_occurrence FOREIGN KEY (delivery_id) REFERENCES deliveries(id) ON DELETE CASCADE;