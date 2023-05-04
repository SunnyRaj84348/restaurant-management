CREATE TABLE item_type (
	itype_id INT PRIMARY KEY AUTO_INCREMENT,
	itype_name VARCHAR(50) UNIQUE
);

CREATE TABLE item (
	item_id INT PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(50) UNIQUE,
	item_type INT,
	item_price DECIMAL(6, 2),
	
	FOREIGN KEY(item_type) REFERENCES item_type(itype_id)
);

CREATE TABLE employee_role (
	erole_id INT PRIMARY KEY AUTO_INCREMENT,
	erole_name varchar(50) UNIQUE
);

CREATE TABLE employee (
	emp_id INT PRIMARY KEY AUTO_INCREMENT,
	emp_name VARCHAR(50),
	emp_phone VARCHAR(13) UNIQUE,
	emp_address VARCHAR(50),
	emp_role INT,
	emp_salary DECIMAL(10, 2),
	
	FOREIGN KEY(emp_role) REFERENCES employee_role(erole_id)
);

CREATE TABLE credential (
	emp_id INT PRIMARY KEY,
	username varchar(50) UNIQUE,
	password VARCHAR(50),
	
	FOREIGN KEY(emp_id) REFERENCES employee(emp_id)
);

CREATE TABLE customer (
	cust_id INT PRIMARY KEY AUTO_INCREMENT,
	cust_name VARCHAR(50),
	cust_phone VARCHAR(13) UNIQUE,
	cust_address VARCHAR(50)
);

CREATE TABLE order_history (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	order_date TIMESTAMP,
	cust_id INT,
	
	FOREIGN KEY(cust_id) REFERENCES customer(cust_id)
);

CREATE TABLE ordered_item (
	order_id INT,
	item_id INT,
	item_quantity INT,
	
	FOREIGN KEY(order_id) REFERENCES order_history(order_id),
	FOREIGN KEY(item_id) REFERENCES item(item_id)
);

ALTER TABLE employee AUTO_INCREMENT=1001;
ALTER TABLE customer AUTO_INCREMENT=2001;
ALTER TABLE order_history AUTO_INCREMENT=3001;

INSERT INTO employee_role VALUES (
	DEFAULT,
	'Admin'
);

INSERT INTO employee VALUES(
	DEFAULT,
	'Admin Kumar',
	'9714563200',
	'x gali, purnia',
	1,
	85000
);

INSERT INTO credential VALUES (
	1001,
	'admin',
	'12345'
);
