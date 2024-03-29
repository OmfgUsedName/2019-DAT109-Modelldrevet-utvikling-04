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


