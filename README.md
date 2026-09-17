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

**Database:** `employee_management`

**Table:** `employees`

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
├── .gitignore
└── README.md
```

## How to Run

1. Install Java JDK.
2. Install MySQL.
3. Create the `employee_management` database and `employees` table.
4. Create a local `config.properties` file in the project root.
5. Add your MySQL password to `config.properties`:

```text
db.password=YOUR_MYSQL_PASSWORD
```

6. Make sure `config.properties` is not uploaded to GitHub. It is already included in `.gitignore`.
7. Open the terminal inside the `src` folder.
8. Compile the project:

```text
javac -cp ".;..\lib\mysql-connector-j-26.7.0.jar" Main.java Employee.java DatabaseConnection.java
```

9. Run the project:

```text
java -cp ".;..\lib\mysql-connector-j-26.7.0.jar" Main
```

## Learning Outcomes

This project helped me practice:

* Java programming
* Object-Oriented Programming
* JDBC database connectivity
* SQL CRUD operations
* Exception handling
* Input validation
* PreparedStatement
* Resource management
* MySQL database integration

