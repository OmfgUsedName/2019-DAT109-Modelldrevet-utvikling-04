-- User_Vote [rel7]
alter table "vote"  add column  "id"  int4;
alter table "vote"   add constraint fk_vote_user foreign key ("id") references "user" ("id");


-- Exhibition_Vote [rel8]
alter table "vote"  add column  "id"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("id") references "exhibition" ("id");


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


-- REL FK: UserToExhibition [rel6#role11]
alter table "exhibition"   add constraint fk_exhibition_user foreign key ("user_id") references "user" ("id");


