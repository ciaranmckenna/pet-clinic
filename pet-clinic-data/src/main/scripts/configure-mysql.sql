## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysql_db_docker -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE dev;
CREATE DATABASE prod;

#Create database service accounts
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'admin';
CREATE USER 'prod_user'@'localhost' IDENTIFIED BY 'admin';
CREATE USER 'dev_user'@'%' IDENTIFIED BY 'admin';
CREATE USER 'prod_user'@'%' IDENTIFIED BY 'admin';

#Database grants
GRANT SELECT ON dev.* to 'dev_user'@'localhost';
GRANT INSERT ON dev.* to 'dev_user'@'localhost';
GRANT DELETE ON dev.* to 'dev_user'@'localhost';
GRANT UPDATE ON dev.* to 'dev_user'@'localhost';
GRANT SELECT ON prod.* to 'prod_user'@'localhost';
GRANT INSERT ON prod.* to 'prod_user'@'localhost';
GRANT DELETE ON prod.* to 'prod_user'@'localhost';
GRANT UPDATE ON prod.* to 'prod_user'@'localhost';
GRANT SELECT ON dev.* to 'dev_user'@'%';
GRANT INSERT ON dev.* to 'dev_user'@'%';
GRANT DELETE ON dev.* to 'dev_user'@'%';
GRANT UPDATE ON dev.* to 'dev_user'@'%';
GRANT SELECT ON prod.* to 'prod_user'@'%';
GRANT INSERT ON prod.* to 'prod_user'@'%';
GRANT DELETE ON prod.* to 'prod_user'@'%';
GRANT UPDATE ON prod.* to 'prod_user'@'%';