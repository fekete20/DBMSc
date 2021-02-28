create database dolgozodb;
use dolgozodb;

drop table dolgozo;
drop table kepzes;

create table dolgozo(did int primary key, dnev varchar(255), beosztas varchar(255), fizetes int);
create table kepzes(kid int primary key, knev varchar(255), oktato varchar(255), idotartam int);
create table dolgkepzes(id int primary key, did int references dolgozo(did), kid int references kepzes(kid));

-- dolgozo(did, dnev, beosztas, fizetes)
insert into dolgozo values(100, 'Dolgozó 1', 'beosztás 1', 620000);
insert into dolgozo values(101, 'Dolgozó 2', 'beosztás 2', 320000);
insert into dolgozo values(102, 'Dolgozó 3', 'beosztás 3', 460000);
insert into dolgozo values(103, 'Dolgozó 4', 'beosztás 2', 200000);
insert into dolgozo values(104, 'Dolgozó 5', 'beosztás 2', 770000);
insert into dolgozo values(105, 'Dolgozó 6', 'beosztás 3', 180000);
insert into dolgozo values(106, 'Dolgozó 7', 'beosztás 1', 930000);

-- kepzes(kid, knev, oktato, idotartam)
insert into kepzes values(100, 'képzés 1', 'oktató 1', 60);
insert into kepzes values(101, 'képzés 2', 'oktató 2', 180);
insert into kepzes values(102, 'képzés 2', 'oktató 3', 300);

insert into dolgkepzes values(1, 100, 100); -- dolgozó1 részt vesz képzés1-en
insert into dolgkepzes values(2, 100, 101); -- dolgozó1 részt vesz képzés2-n
insert into dolgkepzes values(3, 102, 100); -- dolgozó3 részt vesz képzés1-en
insert into dolgkepzes values(4, 103, 100); -- dolgozó4 részt vesz képzés1-en
insert into dolgkepzes values(5, 106, 102); -- dolgozó7 részt vesz képzés3-on
insert into dolgkepzes values(6, 103, 101); -- dolgozó4 részt vesz képzés2-n

select * from dolgozo;
select * from kepzes; 
select * from dolgkepzes;