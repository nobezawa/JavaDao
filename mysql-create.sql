create table checks (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  result                    varchar(255),
  created                   datetime(6),
  modified                  datetime(6),
  constraint pk_checks primary key (id))
;



