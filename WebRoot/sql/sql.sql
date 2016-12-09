create table user_table( 
id int,
name varchar(20) not null unique,
password varchar(20) not null,
register_date date ,
phone varchar(20) not null,
primary key("ID")
);
create sequence user_seq
	increment by 1
	start with 1
;
create trigger user_trigger
	before insert on user_table
	for each row 
	begin 
		select user_seq.nextval into:new.ID from dual;
	end;

insert into user_table (name,password,register_date,phone)
values ('admin','admin',sysdate,110);

select 
e.empno, e.ename, e.job, e.mgr, e2.ename,  e.sal,e.hiredate, e.comm, e.deptno,
d.dname 
from emp e, emp e2 ,dept d
where e.mgr = e2.empno and e.deptno = d.deptno
;
