CREATE DATABASE iCucumber;	
CREATE USER 'teller'@'localhost' IDENTIFIED BY 'cucumber';
GRANT ALL ON iCucumber.* TO 'teller'@'localhost';
