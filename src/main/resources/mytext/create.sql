drop user hellowWord cascade;
create user hellowWord
  identified by "hellowWord"
  default tablespace duanxindata;

-- Grant/Revoke role privileges
grant connect to hellowWord;
grant resource to hellowWord;
-- Grant/Revoke system privileges
grant create database link to hellowWord;
grant create sequence to hellowWord;
grant create synonym to hellowWord;
grant create table to hellowWord;
grant create view to hellowWord;
grant unlimited tablespace to hellowWord;