CREATE DATABASE IF NOT EXISTS fixed_deposit_system;
USE fixed_deposit_system;

CREATE TABLE system_users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('ADMIN','MANAGER','TELLER','USER') DEFAULT 'USER',
    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customer_profiles (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    nic_no VARCHAR(20) NOT NULL UNIQUE,
    phone VARCHAR(20),
    email VARCHAR(100),
    address TEXT,
    date_of_birth DATE,
    customer_type ENUM('INDIVIDUAL','BUSINESS') DEFAULT 'INDIVIDUAL',
    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    account_number VARCHAR(50) NOT NULL UNIQUE,
    account_type ENUM('SAVINGS','CURRENT','FIXED') DEFAULT 'SAVINGS',
    balance DECIMAL(15,2) DEFAULT 0.00,
    account_status ENUM('ACTIVE','INACTIVE','CLOSED') DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (customer_id)
    REFERENCES customer_profiles(customer_id)
    ON DELETE CASCADE
);

CREATE TABLE fixed_deposit_accounts (
    deposit_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    deposit_type VARCHAR(50),
    principal_amount DECIMAL(15,2) NOT NULL,
    interest_rate DECIMAL(5,2) NOT NULL,
    tenure_months INT NOT NULL,
    start_date DATE NOT NULL,
    maturity_date DATE NOT NULL,
    maturity_amount DECIMAL(15,2),
    status ENUM('ACTIVE','MATURED','CLOSED','CANCELLED') DEFAULT 'ACTIVE',
    auto_renew BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (customer_id)
    REFERENCES customer_profiles(customer_id)
    ON DELETE CASCADE
);

CREATE TABLE deposit_transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    deposit_id INT NOT NULL,
    transaction_type ENUM('DEPOSIT','WITHDRAWAL','INTEREST','PENALTY'),
    transaction_amount DECIMAL(15,2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reference_no VARCHAR(100),

    FOREIGN KEY (deposit_id)
    REFERENCES fixed_deposit_accounts(deposit_id)
    ON DELETE CASCADE
);

CREATE TABLE loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    loan_amount DECIMAL(15,2) NOT NULL,
    interest_rate DECIMAL(5,2) NOT NULL,
    loan_period_months INT NOT NULL,
    monthly_installment DECIMAL(15,2),sys_config
    start_date DATE,
    end_date DATE,
    loan_status ENUM('PENDING','APPROVED','ACTIVE','CLOSED','REJECTED') DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (customer_id)
    REFERENCES customer_profiles(customer_id)
    ON DELETE CASCADE
);

-- ADMIN USER
INSERT INTO system_users(username, password_hash, role)
VALUES ('manager', 'manager1234', 'MANAGER');