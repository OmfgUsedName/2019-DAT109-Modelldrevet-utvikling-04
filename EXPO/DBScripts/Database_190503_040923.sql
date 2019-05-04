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


-- Vote_User [rel2]
alter table "user"  add column  "vote_oid"  int4;
alter table "user"   add constraint fk_user_vote foreign key ("vote_oid") references "vote" ("oid");


-- Vote_Exhibition [rel3]
alter table "exhibition"  add column  "vote_oid"  int4;
alter table "exhibition"   add constraint fk_exhibition_vote foreign key ("vote_oid") references "vote" ("oid");


-- User_Exhibition [rel7]
alter table "exhibition"  add column  "user_oid"  int4;
alter table "exhibition"   add constraint fk_exhibition_user foreign key ("user_oid") references "user" ("oid");


