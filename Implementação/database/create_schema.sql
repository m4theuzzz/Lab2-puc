CREATE SCHEMA IF NOT EXISTS Lab;

USE Lab;

CREATE TABLE IF NOT EXISTS users (
	id int not null unique auto_increment,
    name varchar(64) not null,
    password text not null,
    email varchar(64) unique not null,
    type varchar(64) not null default "customer",
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp,
    PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS vehicles (
    id int not null unique auto_increment,
    brand varchar(32) not null,
    model varchar(32) not null,
    year int not null,
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp,
    PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS rents (
    id int not null unique auto_increment,
    requester int not null,
    vehicle_id int not null,
    status varchar(16) not null default "pending",
    expire_at datetime not null,
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp,
    FOREIGN KEY(requester) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY(vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE,
    PRIMARY KEY(id)
) ENGINE = InnoDB;
