//%% NEW FILE Vote BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



CREATE TABLE IF NOT EXISTS `vote`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*vote Associations*/
  user_id INT,
  exhibition_id INT,
  
  /*vote Attributes*/
  id INT,
  PRIMARY KEY(id)

);


ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_user_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);
ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_exhibition_id` FOREIGN KEY (`exhibition_id`) REFERENCES `exhibition`(`id`);




//%% NEW FILE User BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



CREATE TABLE IF NOT EXISTS `user`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*user Associations*/
  exhibition_id INT,
  
  /*user Attributes*/
  id INT,
  name VARCHAR(255),
  type VARCHAR(255),
  PRIMARY KEY(id)

);


ALTER TABLE `user` ADD CONSTRAINT `fk_user_exhibition_id` FOREIGN KEY (`exhibition_id`) REFERENCES `exhibition`(`id`);




//%% NEW FILE Exhibition BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



CREATE TABLE IF NOT EXISTS `exhibition`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*exhibition Attributes*/
  id INT,
  name VARCHAR(255),
  description VARCHAR(255),
  UNKNOWN ID: attributeMany List<BLOB>,
  UNKNOWN ID: attributeMany List<VARCHAR(255)>,
  PRIMARY KEY(id)

);