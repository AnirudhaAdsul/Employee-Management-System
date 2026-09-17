# Employee Management System

A console-based Employee Management System developed using Java, JDBC, and MySQL.

## Features

* Add Employee
* View Employees
* Search Employee by ID
* Update Employee
* Delete Employee
* Input validation
* Duplicate Employee ID handling
* Delete confirmation
* MySQL database integration
* Exception handling

## Technologies Used

* Java
* JDBC
* MySQL
* SQL

## Database Structure

Database name:

`employee_management`

Table name:

`employees`

Columns:

| Column     | Type         | Description                 |
| ---------- | ------------ | --------------------------- |
| id         | INT          | Employee ID and Primary Key |
| name       | VARCHAR(100) | Employee Name               |
| department | VARCHAR(100) | Employee Department         |
| salary     | DOUBLE       | Employee Salary             |

## Project Structure

```text
Employee Management System
│
├── src
│   ├── Main.java
│   ├── Employee.java
│   └── DatabaseConnection.java
│
├── lib
│   └── mysql-connector-j-26.7.0.jar
│
└── README.md
```

## How to Run

1. Install Java JDK.
2. Install MySQL.
3. Create the `employee_management` database and `employees` table.
4. Configure the database connection in `DatabaseConnection.java`.
5. Compile the Java files with the MySQL Connector/J library.
6. Run `Main.java`.

## Learning Outcomes

This project helped me practice Java programming, object-oriented programming, JDBC database connectivity, SQL CRUD operations, exception handling, input validation, and resource management.
