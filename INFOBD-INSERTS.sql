 create table media (
     id bigint not null auto_increment,
      name varchar(255),
      description varchar(255),
      latitude varchar(255),
      longitude varchar(255),
      createDate varchar(255),
      uploadDate varchar(255),
      publicationDate varchar(255),
      primary key (id)
  );


  
insert into user(id,name,description,latitude,longitude,createDate,uploadDate,publicationDate) values (1,'Praia1','dia de sol na praia','11223344','44332211','2019-10-05','2020-02-02','2020-02-02');
insert into user(id,name,description,latitude,longitude,createDate,uploadDate,publicationDate) values (2,'Praia2','dia de chuva na praia','11223344','44332211','2019-10-05','2020-02-02','2020-02-02');
insert into user(id,name,description,latitude,longitude,createDate,uploadDate,publicationDate) values (3,'Praia3','lual na praia','11223344','44332211','2019-10-05','2020-02-02','2020-02-02');
insert into user(id,name,description,latitude,longitude,createDate,uploadDate,publicationDate) values (4,'Praia4','praia','11223344','44332211','2019-10-05','2020-02-02','2020-02-02');


 
  select * from user;
