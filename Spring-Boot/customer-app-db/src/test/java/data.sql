drop table if exists customer CASCADE ;
create table customer (id integer not null, customer_name varchar(50) not null, email varchar(255), dob date,primary key (id));
alter table customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email);
insert into customer (id,customer_name,email,dob) values (1001, 'vivek', 'vivek@gmail.com', '2000-01-29');
insert into customer (id,customer_name,email,dob) values (1002, 'shyma', 'shyma@gmail.com', '1998-02-24');
insert into customer (id,customer_name,email,dob) values (1003, 'ashna', 'ashna@gmail.com', '2000-10-23');