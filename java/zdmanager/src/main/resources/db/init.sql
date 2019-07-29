-- Create table
create table account
(
  id           BIGINT NOT NULL PRIMARY KEY,
  enable       BOOLEAN NOT NULL DEFAULT TRUE,
  name         VARCHAR(36) NOT NULL UNIQUE,
  password 	   VARCHAR(128) NOT NULL,
  email        VARCHAR(64) NOT NULL,
  comment      TEXT
);
--  
 
-- Create table
create table role
(
  id   		   BIGINT NOT NULL PRIMARY KEY,
  enable       BOOLEAN NOT NULL DEFAULT TRUE,
  name         VARCHAR(30) NOT NULL UNIQUE,
  comment      TEXT
);
--   
  
-- Used by Spring Remember Me API.  
CREATE TABLE Persistent_Logins (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
     
);
  
--------------------------------------

INSERT INTO account (id, enable, name, password, email, comment)
VALUES (1, True, 'zsz1210', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'zsz1210@hotmail.com', 'TEST');
 
---

INSERT INTO role (id, enable, name, comment)
VALUES (1, True, 'Adminstrator', 'TEST');
 
---
Commit;
