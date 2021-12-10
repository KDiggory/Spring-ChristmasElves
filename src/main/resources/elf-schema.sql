DROP TABLE IF EXISTS christmas_elf CASCADE;
DROP TABLE IF EXISTS christmas_presents CASCADE;
DROP TABLE IF EXISTS christmas_team CASCADE;

CREATE TABLE christmas_elf (
id INTEGER not null auto_increment, 
age INTEGER, 
best_toy VARCHAR(255), 
favourite_food VARCHAR(255), 
height DOUBLE, 
is_nice BOOLEAN not null, 
name VARCHAR(255), 
primary key (id));


create table christmas_presents (
id integer not null auto_increment,
 colour varchar(255), 
 num_needed integer, 
 type varchar(255), 
 primary key (id));

  
  create table christmas_team (
  id integer not null auto_increment, 
  num_members integer, 
  team_name varchar(255), 
  primary key (id));