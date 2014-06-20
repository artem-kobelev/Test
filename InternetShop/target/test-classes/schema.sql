CREATE TABLE Goods(
   id IDENTITY PRIMARY KEY ,
   name varchar(30),
   price int
);
CREATE TABLE Client(
    id IDENTITY PRIMARY KEY,
    name varchar(30),
    discount int
);
CREATE TABLE Bucket(
    id IDENTITY PRIMARY KEY,
    clietnID int NULL FOREIGN KEY REFERENCES Client(id) on delete cascade,
    goodsID int NULL FOREIGN KEY REFERENCES Goods(id) on delete cascade
) 
