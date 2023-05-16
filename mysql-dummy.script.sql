-- DUMMY DATA

-- Employee Role
INSERT INTO employee_role VALUES
(DEFAULT, 'Manager'),
(DEFAULT, 'Chef'),
(DEFAULT, 'Waiter');

-- Category Type
INSERT INTO category_type VALUES
(DEFAULT, 'Veg'),
(DEFAULT, 'Non-Veg');

-- Item Category
INSERT INTO item_category VALUES
(
	DEFAULT,
	'Chicken',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Non-Veg')
),
(
	DEFAULT,
	'Mutton',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Non-Veg')
),
(
	DEFAULT,
	'Fish',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Non-Veg')
),
(
	DEFAULT,
	'Egg',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Non-Veg')
),
(
	DEFAULT,
	'Paneer',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Veg')
),
(
	DEFAULT,
	'Bread',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Veg')
),
(
	DEFAULT,
	'Dal',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Veg')
),
(
	DEFAULT,
	'Vegetables',
	(SELECT ctype_id FROM category_type WHERE ctype_name = 'Veg')
);

-- Item
INSERT INTO item VALUES
(
		DEFAULT,
		'Chicken Butter Masala',
		(SELECT category_id FROM item_category WHERE category_name = 'Chicken'),
		180
),
(
		DEFAULT,
		'Chicken Kadai',
		(SELECT category_id FROM item_category WHERE category_name = 'Chicken'),
		200
),
(
		DEFAULT,
		'Mutton Curry',
		(SELECT category_id FROM item_category WHERE category_name = 'Mutton'),
		250
),
(
		DEFAULT,
		'Fish Curry',
		(SELECT category_id FROM item_category WHERE category_name = 'Fish'),
		120
),	
(
		DEFAULT,
		'Fish Fry',
		(SELECT category_id FROM item_category WHERE category_name = 'Fish'),
		140
),
(
		DEFAULT,
		'Egg Curry',
		(SELECT category_id FROM item_category WHERE category_name = 'Egg'),
		45
),
(
		DEFAULT,
		'Roti',
		(SELECT category_id FROM item_category WHERE category_name = 'Bread'),
		10
),
(
		DEFAULT,
		'Naan',
		(SELECT category_id FROM item_category WHERE category_name = 'Bread'),
		19
),
(
		DEFAULT,
		'Paneer Butter Masala',
		(SELECT category_id FROM item_category WHERE category_name = 'Paneer'),
		150
),
(
		DEFAULT,
		'Paneer Kadai',
		(SELECT category_id FROM item_category WHERE category_name = 'Paneer'),
		170
),
(
		DEFAULT,
		'Tadka Dal',
		(SELECT category_id FROM item_category WHERE category_name = 'Dal'),
		50
),
(
		DEFAULT,
		'Dal Makhni',
		(SELECT category_id FROM item_category WHERE category_name = 'Dal'),
		80
),
(
		DEFAULT,
		'Aloo Dum',
		(SELECT category_id FROM item_category WHERE category_name = 'Vegetables'),
		50
),
(
		DEFAULT,
		'Mix Veg',
		(SELECT category_id FROM item_category WHERE category_name = 'Vegetables'),
		70
);

-- Customer
INSERT INTO customer VALUES
(
	DEFAULT,
	'Customer1',
	'9854657896',
	'A gali, kolkata'
),
(
	DEFAULT,
	'Customer2',
	'8954632011',
	'D Tower, kolkata'
);
