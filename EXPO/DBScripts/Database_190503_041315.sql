-- User [User]
create table "user" (
   "oid"  int4  not null,
   "username"  varchar(255),
   "passord"  varchar(255),
   "exhibition"  int4,
  primary key ("oid")
);


-- Exhibition [ent1]
create table "exhibition" (
   "oid"  int4  not null,
   "name"  varchar(255),
   "description"  varchar(255),
   "urlphoto"  varchar(255),
  primary key ("oid")
);


-- Vote [ent2]
create table "vote" (
   "oid"  int4  not null,
   "weight"  int4,
   "user"  varchar(255),
   "exhibition"  varchar(255),
  primary key ("oid")
);


