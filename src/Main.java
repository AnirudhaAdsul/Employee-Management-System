
import java.util.Scanner;

public class Main {

    static java.sql.Connection connection;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        connection = DatabaseConnection.getConnection();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Please enter a number between 1 and 6.");
                scanner.next();
                continue;
            }

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:

                    searchEmployee();
                    break;

                case 4:

                    updateEmployee();
                    break;

                case 5:

                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");

                    try {
                        if (connection != null) {
                            connection.close();
                            System.out.println("Database connection closed.");
                        }
                    } catch (java.sql.SQLException e) {
                        System.out.println("Failed to close database connection.");
                    }

                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add Employee
    // Add Employee
    public static void addEmployee() {

        System.out.println("\n----- Add Employee -----");

        int id;

        while (true) {

            System.out.print("Enter Employee ID: ");

            if (scanner.hasNextInt()) {

                id = scanner.nextInt();

                if (id > 0) {
                    break;
                }

                System.out.println("Employee ID must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        scanner.nextLine();

        String name;

        while (true) {

            System.out.print("Enter Employee Name: ");
            name = scanner.nextLine();

            if (!name.trim().isEmpty()) {
                break;
            }

            System.out.println("Employee name cannot be empty.");
        }

        String department;

        while (true) {

            System.out.print("Enter Department: ");
            department = scanner.nextLine();

            if (!department.trim().isEmpty()) {
                break;
            }

            System.out.println("Department cannot be empty.");
        }
        double salary;

        while (true) {

            System.out.print("Enter Salary: ");

            if (scanner.hasNextDouble()) {

                salary = scanner.nextDouble();

                if (salary > 0 && salary <= 100000000) {
                    break;
                }

                System.out.println("Salary must be greater than 0 and less than or equal to 10 crore.");

            } else {

                System.out.println("Please enter a valid salary.");
                scanner.next();
            }
        }
        String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";

        try (java.sql.PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setDouble(4, salary);

            statement.executeUpdate();

            System.out.println("Employee added successfully!");

        } catch (java.sql.SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("Employee ID already exists. Please use a different ID.");
            } else {
                System.out.println("Failed to add employee.");
                e.printStackTrace();
            }
        }
    }

    // View Employees
    // View Employees
    // View Employees
    public static void viewEmployees() {

        System.out.println("\n----- Employee List -----");

        String sql = "SELECT * FROM employees";

        try (java.sql.Statement statement = connection.createStatement(); java.sql.ResultSet result = statement.executeQuery(sql)) {

            boolean found = false;
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-18s %s%n",
                    "ID", "Name", "Department", "Salary");
            System.out.println("------------------------------------------------------------");

            while (result.next()) {

                found = true;

                int id = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                double salary = result.getDouble("salary");

                System.out.printf("%-10d %-20s %-18s %.2f%n",
                        id, name, department, salary);
            }

            if (!found) {
                System.out.println("No employees found.");
            }

        } catch (java.sql.SQLException e) {

            System.out.println("Failed to view employees.");
            e.printStackTrace();
        }
    }
    // Search Employee

    // Search Employee
    // Search Employee
    public static void searchEmployee() {

        System.out.println("\n----- Search Employee -----");

        int id;

        while (true) {

            System.out.print("Enter Employee ID to search: ");

            if (scanner.hasNextInt()) {

                id = scanner.nextInt();

                if (id > 0) {
                    break;
                }

                System.out.println("Employee ID must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (java.sql.PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (java.sql.ResultSet result = statement.executeQuery()) {

                if (result.next()) {

                    System.out.println("\nEmployee Found!");
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%-10s %-20s %-18s %s%n",
                            "ID", "Name", "Department", "Salary");
                    System.out.println("------------------------------------------------------------");

                    System.out.printf("%-10d %-20s %-18s %.2f%n",
                            result.getInt("id"),
                            result.getString("name"),
                            result.getString("department"),
                            result.getDouble("salary"));

                    System.out.println("------------------------------------------------------------");

                } else {

                    System.out.println("Employee not found.");
                }
            }

        } catch (java.sql.SQLException e) {

            System.out.println("Failed to search employee.");
            e.printStackTrace();
        }
    }
    // Update Employee

    // Update Employee
    // Update Employee
    public static void updateEmployee() {

        System.out.println("\n----- Update Employee -----");

        int id;

        while (true) {

            System.out.print("Enter Employee ID to update: ");

            if (scanner.hasNextInt()) {

                id = scanner.nextInt();

                if (id > 0) {
                    break;
                }

                System.out.println("Employee ID must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        while (name.trim().isEmpty()) {

            System.out.println("Employee name cannot be empty.");
            System.out.print("Enter new name: ");
            name = scanner.nextLine();
        }

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        while (department.trim().isEmpty()) {

            System.out.println("Department cannot be empty.");
            System.out.print("Enter new department: ");
            department = scanner.nextLine();
        }

        double salary;

        while (true) {

            System.out.print("Enter new salary: ");

            if (scanner.hasNextDouble()) {

                salary = scanner.nextDouble();

                if (salary > 0 && salary <= 100000000) {
                    break;
                }

                System.out.println("Salary must be greater than 0 and less than or equal to 10 crore.");
            } else {

                System.out.println("Please enter a valid salary.");
                scanner.next();
            }
        }

        String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";

        try (java.sql.PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, department);
            statement.setDouble(3, salary);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee updated successfully!");

            } else {

                System.out.println("Employee not found.");
            }

        } catch (java.sql.SQLException e) {

            System.out.println("Failed to update employee.");
            e.printStackTrace();
        }
    }
    // Delete Employee

    // Delete Employee
    // Delete Employee
    public static void deleteEmployee() {

        System.out.println("\n----- Delete Employee -----");

        int id;

        while (true) {

            System.out.print("Enter Employee ID to delete: ");

            if (scanner.hasNextInt()) {

                id = scanner.nextInt();

                if (id > 0) {
                    break;
                }

                System.out.println("Employee ID must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        String sql = "DELETE FROM employees WHERE id = ?";

        try (java.sql.PreparedStatement statement
                = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            scanner.nextLine();

            System.out.print("Are you sure you want to delete this employee? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (!confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Delete cancelled.");
                return;
            }

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Failed to delete employee.");
            e.printStackTrace();
        }
    }
}
