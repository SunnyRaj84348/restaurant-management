CREATE TABLE category_type (
	ctype_id INT PRIMARY KEY AUTO_INCREMENT,
	ctype_name VARCHAR(50) UNIQUE
);

CREATE TABLE item_category (
	category_id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(50) UNIQUE,
	category_type INT,
	
	FOREIGN KEY(category_type) REFERENCES category_type(ctype_id)
);

CREATE TABLE item (
	item_id INT PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(50) UNIQUE,
	item_category INT,
	item_price DECIMAL(6, 2),
	
	FOREIGN KEY(item_category) REFERENCES item_category(category_id)
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
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
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


-- DEFAULT DATA

-- Employee Role
INSERT INTO employee_role VALUES
(DEFAULT, 'Admin'),
(DEFAULT, 'Receptionist');

-- Employee
INSERT INTO employee VALUES
(
	DEFAULT,
	'Admin Kumar',
	'9714563200',
	'x gali, purnia',
	(SELECT erole_id FROM employee_role WHERE erole_name = 'Admin'),
	85000
),
(
	DEFAULT,
	'Receptionist Kumari',
	'8754654100',
	'Abc chowk, purnia',
	(SELECT erole_id FROM employee_role WHERE erole_name = 'Receptionist'),
	45000
);

-- Credential
INSERT INTO credential VALUES
(
	(SELECT emp_id FROM employee WHERE emp_phone = 9714563200),
	'admin@123',
	'12345'
),
(
	(SELECT emp_id FROM employee WHERE emp_phone = 8754654100),
	'receptionist@123',
	'12345'
);
