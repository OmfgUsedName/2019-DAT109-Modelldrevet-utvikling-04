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
   "exhibition"  int4,
   "passord"  varchar(255),
   "username"  varchar(255),
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
   "exhibition_id"  int4  not null,
   "user_id"  int4  not null,
   "weight"  int4,
  primary key ("exhibition_id", "user_id")
);


-- Group_DefaultModule [Group2DefaultModule_DefaultModule2Group]
alter table "group"  add column  "module_oid"  int4;
alter table "group"   add constraint fk_group_module foreign key ("module_oid") references "module" ("oid");
create index "idx_group_module" on "group"("module_oid");


-- Group_Module [Group2Module_Module2Group]
create table "group_module" (
   "group_oid"  int4 not null,
   "module_oid"  int4 not null,
  primary key ("group_oid", "module_oid")
);
alter table "group_module"   add constraint fk_group_module_group foreign key ("group_oid") references "group" ("oid");
alter table "group_module"   add constraint fk_group_module_module foreign key ("module_oid") references "module" ("oid");
create index "idx_group_module_group" on "group_module"("group_oid");
create index "idx_group_module_module" on "group_module"("module_oid");


-- User_DefaultGroup [User2DefaultGroup_DefaultGroup2User]
alter table "user"  add column  "group_oid"  int4;
alter table "user"   add constraint fk_user_group foreign key ("group_oid") references "group" ("oid");
create index "idx_user_group" on "user"("group_oid");


-- User_Group [User2Group_Group2User]
create table "user_group" (
   "user_id"  int4 not null,
   "group_oid"  int4 not null,
  primary key ("user_id", "group_oid")
);
alter table "user_group"   add constraint fk_user_group_user foreign key ("user_id") references "user" ("id");
alter table "user_group"   add constraint fk_user_group_group foreign key ("group_oid") references "group" ("oid");
create index "idx_user_group_user" on "user_group"("user_id");
create index "idx_user_group_group" on "user_group"("group_oid");


-- User_Exhibition [rel6]
alter table "user"  add column  "id"  int4;
alter table "exhibition"   add constraint fk_user_exhibition foreign key ("id") references "exhibition" ("id");
create index "idx_user_exhibition" on "exhibition"("id");


-- User_Vote [rel7]
alter table "vote"  add column  "id"  int4;
alter table "vote"   add constraint fk_vote_user foreign key ("id") references "user" ("id");
create index "idx_vote_user" on "vote"("id");


-- Exhibition_Vote [rel8]
alter table "vote"  add column  "id"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("id") references "exhibition" ("id");
create index "idx_vote_exhibition" on "vote"("id");


