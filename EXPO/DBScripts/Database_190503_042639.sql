-- Vote_User [rel4]
alter table "user"  add column  "vote_user_id"  int4;
alter table "user"  add column  "vote_exhibition_id"  int4;
alter table "user"   add constraint fk_user_vote foreign key ("vote_user_id", "vote_exhibition_id") references "vote" ("user_id", "exhibition_id");


-- Vote_Exhibition [rel5]
alter table "exhibition"  add column  "vote_user_id"  int4;
alter table "exhibition"  add column  "vote_exhibition_id"  int4;
alter table "exhibition"   add constraint fk_exhibition_vote foreign key ("vote_user_id", "vote_exhibition_id") references "vote" ("user_id", "exhibition_id");


-- User_Exhibition [rel6]
alter table "exhibition"  add column  "user_id"  int4;
alter table "exhibition"   add constraint fk_exhibition_user foreign key ("user_id") references "user" ("id");


