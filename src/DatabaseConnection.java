import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_management";

    private static final String USER =
            "root";

    public static Connection getConnection() {

        Properties properties = new Properties();

        try {
            FileInputStream file =
                    new FileInputStream("../config.properties");

            properties.load(file);
            file.close();

            String password =
                    properties.getProperty("db.password");

            Connection connection =
                    DriverManager.getConnection(URL, USER, password);

            System.out.println("Database connected successfully!");
            return connection;

        } catch (IOException e) {

            System.out.println("Could not read config.properties.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}