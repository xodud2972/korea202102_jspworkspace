create table product(
	product_id int primary key auto_increment 
	, subcategory_id int 
	, product_name varchar(30)
	, brand varchar(25)
	, price int default 0 
	, info text
) default character set utf8;
