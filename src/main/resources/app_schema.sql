create database FreshShop;
use Freshshop;
-- drop database FreshShop;
CREATE TABLE IF NOT EXISTS `contact_msg` (
    `contact_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `mobile_num` VARCHAR(10) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `subject` VARCHAR(100) NOT NULL,
    `message` VARCHAR(500) NOT NULL,
    `status` VARCHAR(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` VARCHAR(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `categories`(
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
);


CREATE TABLE IF NOT EXISTS `products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `category_id` INT  NOT NULL,
  `description` TEXT,
  `price` DECIMAL(10,2) NOT NULL,
  `product_img` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`category_id`) REFERENCES categories(`category_id`)
);


CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address1` varchar(200) NOT NULL,
  `address2` varchar(200) DEFAULT NULL,
  `zip_code` int NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`address_id`)
);


CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(255) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `address_id` int NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  FOREIGN KEY (`role_id`) REFERENCES roles(`role_id`),
  FOREIGN KEY (`address_id`) REFERENCES address(`address_id`)
);


CREATE TABLE IF NOT EXISTS `orders`(
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `total_amount` DECIMAL(10,2) not null,
  `full_name` nvarchar(250) not null,
  `phone_number` varchar(10) not null,
  `address` NVARCHAR(250) NOT NULL,
  `status` varchar(25) not null,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`)
  );


CREATE TABLE IF NOT EXISTS `order_details` (
  `order_details_id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  `amount`  DECIMAL(10,2) not null,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`order_details_id`),
  FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
);

