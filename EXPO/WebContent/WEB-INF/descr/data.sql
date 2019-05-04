INSERT INTO exhibition (id, name, description, urlphoto) values (1, 'stigs exhibition', 'description', 'https://images.pexels.com/photos/556416/pexels-photo-556416.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
INSERT INTO exhibition (id, name, description, urlphoto) values (2, 'abe exhibition', 'description2', 'https://images.pexels.com/photos/556416/pexels-photo-556416.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
INSERT INTO exhibition (id, name, description, urlphoto) values (3, 'dabe exhibition', 'description3', 'https://images.pexels.com/photos/556416/pexels-photo-556416.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');

INSERT INTO user (id, username, passord, exhibition) values (1, 'admin', 'stig', 0);
INSERT INTO user (id, username, passord, exhibition) values (2, '1', 'stig', 1);
INSERT INTO user (id, username, passord, exhibition) values (3, '2', 'stig', 2);
INSERT INTO user (id, username, passord, exhibition) values (4, '3', 'stig', 2);

INSERT INTO vote (user_id, exhibition_id, weight) values (2,2,3);
INSERT INTO vote (user_id, exhibition_id, weight) values (3,3,4);
INSERT INTO vote (user_id, exhibition_id, weight) values (4,1,5);