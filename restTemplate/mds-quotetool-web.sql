create table mds_quotetool_web(reportType varchar(10),fromdt date,todate date,product varchar(25));
select * from mds_quotetool_web;
insert into mds_quotetool_web values ('summary','04/22/2017','05/28/2017','nexen');
select * from MDS_QUOTETOOL_WEB where reportType = 'summary' and fromdt >= '2017-04-20' and todate <='2017-05-29';

select max(todate) from MDS_QUOTETOOL_WEB;

