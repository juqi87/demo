-- 用户信息  --
drop table USER_INFO;
create table USER_INFO
(
	USER_ID				int(9) primary key auto_increment,
	LOGIN_NAME			varchar(50) not null,
	REAL_NAME			varchar(20) not null,
	PASSWORD			varchar(100),
	TEL					int(11),
	EMAIL				varchar(200) not null,
	DEPT				varchar(100),
	STAT				char(1) default 'C',
	role_id				int(4),
	CREATE_TIME			datetime default now(),
	UPDATE_TIME			timestamp
)ENGINE=innodb;
ALTER TABLE `user_info` ADD UNIQUE INDEX `USER_ID_UN0` (`USER_ID`) USING BTREE ;

-- 该套系统按照模块来划分权限()主要考虑该套系统作为客户端的存在故而按模块来划分权限,若涉及后台控台可按照菜单来划分权限 
--create table module_info(
--	module_id 			number(4) constraint module_info_id_pk primary key,
--	module_name 				varchar(50) not null,
--	module_icon			varchar(25),
--	SERIAL				int(2),
--	stat				char(1) default 'C',
--	CREATE_TIME			datetime default now(),
--	UPDATE_TIME			timestamp
--);

--角色表
drop table ROLE_INFO;
create table ROLE_INFO(
	ROLE_ID			int(4) primary key,
	ROLE_NAME		varchar(50) 	not null,
	CREATE_TIME			datetime default now(),
	UPDATE_TIME			timestamp
)ENGINE=innodb;

create table ROLE_MENU(
	ROLE_ID		int(4) not null,
	MENU_ID		int(6) not null,
	STAT		char(1) default 'C',
	CREATE_TIME			datetime default now(),
	UPDATE_TIME			timestamp,
	primary key(ROLE_ID,MENU_ID)
)ENGINE=innodb;

-- 菜单 --
drop table menu;
create table MENU_INFO (
	MENU_ID				int(6),
	MENU_NAME			varchar(20),
	MENU_LEVEL			int(1),
	MODULE_ICON			varchar(25),
	PARENT_ID			int(6),
	HAVE_SON			char(1) default 'N',
	SERIAL				int(2),
	STAT				char(1) default 'C',
	CREATE_TIME			datetime default now(),
	UPDATE_TIME			timestamp
)ENGINE=INNODB;

show tables;
drop table test;
create table test(
	id	int(15) primary key auto_increment,
	a	datetime,
	b 	timestamp
);
select * from test;
insert test (a, b) value(CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
update test set id=3  where id=1;

create table DB_TEST(
	stat varchar(5)
);
insert DB_TEST value('DB_OK');
select * from db_test;




-- 机构部门表 --
drop table DEPARTMENT;
create table DEPARTMENT
(
	ID							int(15) primary key auto_increment,
	DEPT_ID						varchar(100),
	DEPT_NAME					varchar(100)
)ENGINE=innodb;

insert into department (DEPT_ID, DEPT_NAME) values ('A', '人事管理部门');
insert into department (DEPT_ID, DEPT_NAME) values ('B', '市场开发部门');
insert into department (DEPT_ID, DEPT_NAME) values ('C', '资源管理部门');
insert into department (DEPT_ID, DEPT_NAME) values ('D', '开发管理部门');
insert into department (DEPT_ID, DEPT_NAME) values ('E', '科研研发部门');
insert into department (DEPT_ID, DEPT_NAME) values ('F', '销售部门');


-- 职位表 --
drop table position;
create table POSITION
(
	ID							int(15) primary key auto_increment,
	POS_ID						varchar(100),
	POS_NAME					varchar(50)
)ENGINE=innodb;
select * from position;
insert into position (POS_ID, POS_NAME) values ('a', '高等学校管理人员');
insert into position (POS_ID, POS_NAME) values ('b', '高等学校教师/科研人员');
insert into position (POS_ID, POS_NAME) values ('c', '科研机构管理人员');
insert into position (POS_ID, POS_NAME) values ('d', '国际性组织官员/工作人员');
insert into position (POS_ID, POS_NAME) values ('e', '政府官员');
insert into position (POS_ID, POS_NAME) values ('f', '学生');
insert into position (POS_ID, POS_NAME) values ('g', '家长');
insert into position (POS_ID, POS_NAME) values ('h', '其他');

-- 问卷表 --
drop table survey;
create table SURVEY
(
	ID							int(15) primary key auto_increment,
	SURVEY_ID					varchar(100),
	SUR_TITLE					varchar(200) not null,
	SUR_TYPE_ID					varchar(200) not null,
	USER_ID						varchar(100) not null,
	PATH						varchar(300) not null,
	CREATE_TIME					timestamp default CURRENT_TIMESTAMP,
	UPDATE_TIME					timestamp,
	IS_BEGIN					int default 0,
	START_TIME					timestamp,
	END_TIME					timestamp,
	IS_DELETE					int(8) default 0
)ENGINE=INNODB;

-- 问卷类型表 --
drop table SURVEY_TYPE;
create table SURVEY_TYPE
(
	ID							int(15) primary key auto_increment,
	SUR_TYPE_ID					varchar(100),
	SUR_TYPE_NAME				varchar(50)
)ENGINE=innodb;
select * from SURVEY_TYPE;
insert into SURVEY_TYPE (ID, SUR_TYPE_NAME) values (1, '数据填写类问卷');
insert into SURVEY_TYPE (ID, SUR_TYPE_NAME) values (2, '混合类型问卷');

-- 问题表 --
drop table question;
create table QUESTION
(
	ID							int(15) primary key auto_increment,
	QUES_TITLE					varchar(500),
	QUES_CONTENT				text(2000),
	ANSWER_TITLE				varchar(500),
	SURVEY_ID					int(15),
	QUES_TYPE_ID				int(15),
	CREATE_TIME					timestamp default CURRENT_TIMESTAMP,
	UPDATE_TIME					timestamp,
	ERROR_TIP					varchar(500),
	IS_DELETE					int(8) default 0
)ENGINE=innodb;

-- 问题类型表 --
drop table QUESTION_TYPE;
create table QUESTION_TYPE
(
	ID							int(15) primary key auto_increment,
	QUES_TYPE_ID				varchar(100),
	QUES_TYPE_NAME				varchar(100)
)ENGINE=INNODB;
insert into QUESTION_TYPE (ID, QUES_TYPE_NAME) values (1, '数据填写类问题');
insert into QUESTION_TYPE (ID, QUES_TYPE_NAME) values (2, '单项选择类问题');
insert into QUESTION_TYPE (ID, QUES_TYPE_NAME) values (3, '单项选择SELECT类问题');
insert into QUESTION_TYPE (ID, QUES_TYPE_NAME) values (4, '多项选择类问题');
insert into QUESTION_TYPE (ID, QUES_TYPE_NAME) values (5, '问答题类问题');












-- 填写问卷者表 --
drop table SURVEY_USER;
create table SURVEY_USER
(
	ID							int(15) primary key auto_increment,
	SURVEY_USER_ID				varchar(100),
	LOGIN_NAME					varchar(50),
	NAME						varchar(20),
	PASSWORD					varchar(100),
	EMAIL						varchar(200) not null,
	DEPT_ID						varchar(100),
	POS_ID						varchar(100),
	IS_DELETE					int(8) default 0
)ENGINE=INNODB;

-- 填写问卷者参与问卷表 --
drop table PARTICIPATE_SURVEY;
create table PARTICIPATE_SURVEY
(
	ID							int(15) primary key auto_increment,
	PARTICIPATE_SURVEY_ID		varchar(100),
	SURVEY_ID					varchar(100),
	SUBMIT_TIME					timestamp,
	UPDATE_TIME					timestamp,
	IS_DELETE					int(8) default 0
)ENGINE=INNODB;

-- 问卷填写表 --
drop table ANSWER;
create table ANSWER
(
	ID							int(15) primary key auto_increment,			-- 自增ID --
	USER_ID						varchar(100),
	SURVEY_ID					int(15),
	QUESTION_ID					int(15),
	IS_FILLED					int(8) default 0,
	QUES_ANSWER					varchar(100),									
	IS_DELETE					int(8) default 0							-- 是否删除（0=否，1=是）--
)ENGINE=INNODB;











