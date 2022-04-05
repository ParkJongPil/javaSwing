show tables;

CREATE TABLE javagreen04.cafe LIKE javagreen05.cafe;

INSERT INTO javagreen04.cafe SELECT * FROM javagreen05.cafe;

 create table cafe(
	idx int not null auto_increment primary key,
	part varchar(20) not null default '커피',
	menuName varchar(30) not null,
	price int not null
	);
	
 create table list(
	idx int not null auto_increment primary key,
	name varchar(5) default '사람',
	menuName varchar(300) not null,
	price int not null,
	saleDay datetime default now() 
	);
	

	
desc cafe;
desc list;

drop table cafe;

insert into cafe values (default, default, '아메리카노', 3000);
insert into cafe values (default, default, '콜드브루 아메리카노', 3000);
insert into cafe values (default, default, '카페 라떼', 3000);
insert into cafe values (default, default, '콜드브루 라떼', 3000);
insert into cafe values (default, default, '바닐라 라떼', 3000);
insert into cafe values (default, default, '카라멜 마끼아또', 3000);
insert into cafe values (default, default, '헤이즐넛 / 시럽 추가', 500);
insert into cafe values (default, default, '샷 추가/ 휘핑 추가', 500);

insert into cafe values (default, '라떼', '녹차라떼', 3000);
insert into cafe values (default, '라떼', '카라멜 초코라떼', 3000);
insert into cafe values (default, '라떼', '토피넛 라떼', 3000);
insert into cafe values (default, '라떼', '로얄 밀크티', 3000);
insert into cafe values (default, '라떼', '딸기 라떼', 3000);

insert into cafe values (default, '에이드', '레몬 에이드', 3500);
insert into cafe values (default, '에이드', '모히또 에이드', 3500);
insert into cafe values (default, '에이드', '자몽 에이드', 3500);
insert into cafe values (default, '에이드', '청포드 에이드', 3500);
insert into cafe values (default, '에이드', '패션 후르츠 에이드', 3500);
insert into cafe values (default, '에이드', '블루레몬 에이드', 3500);

insert into cafe values (default, '프라페', '초코칩 프라페', 4000);
insert into cafe values (default, '프라페', '자바칩 프라페', 4000);
insert into cafe values (default, '프라페', '민트칩 프라페', 4000);
insert into cafe values (default, '프라페', '오레오 프라페', 4000);
insert into cafe values (default, '프라페', '녹차 프라페', 4000);
insert into cafe values (default, '프라페', '토피넛 프라페', 4000);


select * from cafe;
select * from list;

select * from cafe where menuName = '아메리카노';

delete from list;
drop table list;

select distinct substring(saleDay,1,10) from list;

select * from list where substring(saleDay,1,10) = '2022-04-04';












/*
create table cafe (
  고유번호  int not null  primary key,
  분류1   varchar(20) not null,
  품명    varchar(30) not null 20,
  분류2 	 varchar(20) default '남',
  가격  	int  		 not null
  사이즈  default now()
);

insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);
insert into cafe values (default,'아메리카노',25,default,default);

select * from cafe;

drop table cafe;
*/