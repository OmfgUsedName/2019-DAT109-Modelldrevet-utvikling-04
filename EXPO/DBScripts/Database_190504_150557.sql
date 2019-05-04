-- Vote [ent2]
create table "vote" (
   "weight"  int4,
   "user_id"  int4  not null,
   "exhibition_id"  int4  not null,
  primary key ("user_id", "exhibition_id")
);


-- Exhibition_User [rel25]
alter table "user"  add column  "exhibition_leader"  int4;
alter table "user"   add constraint fk_user_exhibition foreign key ("exhibition_leader") references "exhibition" ("leader");


-- Vote_User [rel29]
alter table "vote"  add column  "user_id_2"  int4;
alter table "vote"   add constraint fk_vote_user foreign key ("user_id_2") references "user" ("id");


-- Vote_Exhibition [rel30]
alter table "vote"  add column  "exhibition_leader"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("exhibition_leader") references "exhibition" ("leader");


-- REL FK: defaultGroups [DefaultModule2Group]
alter table "group"   add constraint fk_group_module foreign key ("module_oid") references "module" ("oid");


-- REL FK: modules [Group2Module]
alter table "group_module"   add constraint fk_group_module_group foreign key ("group_oid") references "group" ("oid");


-- REL FK: groups [Module2Group]
alter table "group_module"   add constraint fk_group_module_module foreign key ("module_oid") references "module" ("oid");


-- REL FK: defaultUsers [DefaultGroup2User]
alter table "user"   add constraint fk_user_group foreign key ("group_oid") references "group" ("oid");


-- REL FK: groups [User2Group]
alter table "user_group"   add constraint fk_user_group_user foreign key ("user_id") references "user" ("id");


-- REL FK: users [Group2User]
alter table "user_group"   add constraint fk_user_group_group foreign key ("group_oid") references "group" ("oid");


