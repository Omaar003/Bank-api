CREATE TABLE Account (
    CardNumber int NOT NULL ,
    UserName varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    balance int DEFAULT 0,
    PRIMARY KEY (CardNumber)
);



INSERT into Account (cardNumber,UserName,Password)
 Values(1002,'Ahmed','3232');