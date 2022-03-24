--테이블 삭제
drop table product;

--시퀀스 삭제
drop sequence product_id_seq;

--테이블 생성
create table product (
    id      number(30),
    name    varchar2(50),
    amount  number(30),
    price   number(30)

);

--기본키 생성
alter table product add Constraint product_id_pk primary key (id);

--시퀀스 생성
create sequence product_id_seq;