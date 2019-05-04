-- Group [Group]
create table "group" (
   "oid"  int4  not null,
   "groupname"  varchar(255),
  primary key ("oid")
);


-- Module [Module]
create table "module" (
   "oid"  int4  not null,
   "moduleid"  varchar(255),
   "modulename"  varchar(255),
  primary key ("oid")
);


-- User [User]
create table "user" (
   "id"  int4  not null,
   "username"  varchar(255),
   "passord"  varchar(255),
   "exhibition"  int4,
  primary key ("id")
);


-- Exhibition [ent1]
create table "exhibition" (
   "id"  int4  not null,
   "name"  varchar(255),
   "description"  varchar(255),
   "urlphoto"  varchar(255),
  primary key ("id")
);


-- Vote [ent2]
create table "vote" (
   "weight"  int4,
   "user_id"  int4  not null,
   "exhibition_id"  int4  not null,
  primary key ("user_id", "exhibition_id")
);


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table "group"  add column  "module_oid"  int4;
alter table "group"   add constraint fk_group_module foreign key ("module_oid") references "module" ("oid");


-- Group_Module [Group2Module_Module2Group]
create table "group_module" (
   "group_oid"  int4 not null,
   "module_oid"  int4 not null,
  primary key ("group_oid", "module_oid")
);
alter table "group_module"   add constraint fk_group_module_group foreign key ("group_oid") references "group" ("oid");
alter table "group_module"   add constraint fk_group_module_module foreign key ("module_oid") references "module" ("oid");


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table "user"  add column  "group_oid"  int4;
alter table "user"   add constraint fk_user_group foreign key ("group_oid") references "group" ("oid");


-- User_Group [User2Group_Group2User]
create table "user_group" (
   "user_id"  int4 not null,
   "group_oid"  int4 not null,
  primary key ("user_id", "group_oid")
);
alter table "user_group"   add constraint fk_user_group_user foreign key ("user_id") references "user" ("id");
alter table "user_group"   add constraint fk_user_group_group foreign key ("group_oid") references "group" ("oid");


-- User_Exhibition [rel6]
alter table "user"  add column  "id"  int4;
alter table "user"   add constraint fk_user_exhibition foreign key ("id") references "exhibition" ("id");


-- Exhibition_Vote [rel8]
alter table "vote"  add column  "id"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("id") references "exhibition" ("id");


-- Vote_User [rel9]
alter table "user"  add column  "vote_user_id"  int4;
alter table "user"  add column  "vote_exhibition_id"  int4;
alter table "user"   add constraint fk_user_vote foreign key ("vote_user_id", "vote_exhibition_id") references "vote" ("user_id", "exhibition_id");


