create TABLE EMPLOYEE(
Ssn CHAR(9) NOT NULL unique,
EName VARCHAR(15) NOT NULL UNIQUE,
Address VARCHAR(30),
Salary DECIMAL(10,2),
Union_mem_no VARCHAR(9),
Phone_no CHAR(10),
ERole VARCHAR(30),
PRIMARY KEY(Ssn)
);

create table TECHNICIAN(
Ssn CHAR(9) NOT NULL unique,
FOREIGN KEY(Ssn) REFERENCES EMPLOYEE(Ssn));

create table TRAFFICCONTROLLER(
Ssn CHAR(9) NOT NULL,
Exam_date DATE,
PRIMARY KEY(Ssn,Exam_date),
FOREIGN KEY(Ssn) REFERENCES EMPLOYEE(Ssn));


create table AirplaneModel(
Model_no INT NOT NULL unique,
Capacity INT NOT NULL,
Weight INT NOT NULL,
PRIMARY KEY(Model_no) );

create table EXPERT(
Model_no INT NOT NULL,
Ssn CHAR(9) NOT NULL,
FOREIGN KEY(Model_no) REFERENCES AirplaneModel(Model_no),
FOREIGN KEY(Ssn) REFERENCES TECHNICIAN(Ssn));

create table PLANE(
Reg_no INT NOT NULL unique ,
Model_no INT NOT NULL,
PRIMARY KEY(Reg_no),
FOREIGN KEY(Model_no) REFERENCES AirplaneModel(Model_no));

create table FAA_TEST(
FAA_no CHAR(6) NOT NULL unique,
TName VARCHAR(15),
max_score INT NOT NULL,
PRIMARY KEY(FAA_no));

create table TEST_INFO(
FAA_no CHAR(6) NOT NULL,
Reg_no INT NOT NULL,
Ssn CHAR(9) NOT NULL,
Hours INT NOT NULL,
TDate DATE NOT NULL,
Score INT NOT NULL,
FOREIGN KEY(FAA_no) REFERENCES FAA_TEST(FAA_no),
FOREIGN KEY(Reg_no) REFERENCES PLANE(Reg_no),
FOREIGN KEY(Ssn) REFERENCES EMPLOYEE(Ssn),
PRIMARY KEY(TDate,FAA_no,Reg_no,Ssn));