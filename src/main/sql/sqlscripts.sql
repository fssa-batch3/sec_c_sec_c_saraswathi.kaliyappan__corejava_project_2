USE saraswathi_kaliyappan_corejava_project;

CREATE TABLE products (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(255) NOT NULL,
    productDescription VARCHAR(1000),
    productPrice DOUBLE NOT NULL,
    productImage VARCHAR(255),
    productCapacity INT NOT NULL
);
select* from products



