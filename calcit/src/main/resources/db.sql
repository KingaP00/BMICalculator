USE calcit; 

CREATE TABLE USER (
  user_id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE BMI (
bmi_id INT PRIMARY KEY,
bmi_value DOUBLE NOT NULL,
timestamp TIMESTAMP NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE PPM (
ppm_id INT PRIMARY KEY,
ppm_value DOUBLE NOT NULL,
timestamp TIMESTAMP NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE YMCA (
ymca_id INT PRIMARY KEY,
ymca_value DOUBLE NOT NULL,
timestamp TIMESTAMP NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE PRAL (
pral_id INT PRIMARY KEY,
pral_value DOUBLE NOT NULL,
timestamp TIMESTAMP NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES USER(user_id)
);