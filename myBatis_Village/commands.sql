create database village;
use village;

create table village (id int primary key, name varchar(50) default null, district varchar(50) default null);

insert into village values(1, 'Miskolc', 'Borsod');
insert into village values(2, 'Ózd', 'Borsod');
insert into village values(3, 'Szekszárd', 'Tolna');
commit;

select * from village;

drop table village;