-- Exhibition_Vote_2 [rel2]
alter table "vote"  add column  "exhibition_id_2"  int4;
alter table "vote"   add constraint fk_vote_exhibition foreign key ("exhibition_id_2") references "exhibition" ("id");


