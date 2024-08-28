CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    address TEXT,
    age INT,
    phone BIGINT,
    aadhar BIGINT UNIQUE
);

INSERT INTO employee (employee_name, address, age, phone, aadhar) 
VALUES 
('Ashish', '123 Elm Street, Springfield, IL', 30, 5551234, 333556305510),
('Ashwini', '456 Oak Avenue, Springfield, IL', 28, 5555678, 987654321098),
('Pruthvi', '789 Pine Road, Springfield, IL', 35, 5559101, 112233445566),
('Akshay', '101 Maple Lane, Springfield, IL', 40, 5552345, 223344556677),
('Adith', '202 Birch Blvd, Springfield, IL', 25, 5556789, 334455667788);

