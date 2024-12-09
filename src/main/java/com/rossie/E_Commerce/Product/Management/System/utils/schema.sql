CREATE TABLE categories (
                            categoryId BIGSERIAL PRIMARY KEY,
                            categoryName VARCHAR(255) UNIQUE NOT NULL,
                            description TEXT,
                            createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
                          productId BIGSERIAL PRIMARY KEY,
                          productName VARCHAR(255) NOT NULL,
                          productDescription VARCHAR(1000),
                          productPrice DECIMAL(11, 2) NOT NULL CHECK (productPrice >= 0),
                          productStock INT NOT NULL CHECK (productStock >= 0),
                          createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updatedAt TIMESTAMP,
                          categoryId BIGINT,
                          FOREIGN KEY (categoryId) REFERENCES categories (categoryId) ON DELETE CASCADE
);
