-- Vote_User [rel31]
alter table "vote"  add column  "user_id_2"  int4;
alter table "vote"   add constraint fk_vote_user foreign key ("user_id_2") references "user" ("id");


-- Vote_Exhibition [rel32]
alter table "vote"  add column  "exhibition_leader"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("exhibition_leader") references "exhibition" ("leader");


