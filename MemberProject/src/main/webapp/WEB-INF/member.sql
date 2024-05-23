
select * from board_member;

--암호와 테스트
select '123456', standard_hash('123456','SHA512') from dual;

insert into board_member values(?,?,standard_hash(?,'SHA512'),?);
insert into board_member 
values('A0001','김철수',standard_hash('123456','SHA512'),'IronKim');