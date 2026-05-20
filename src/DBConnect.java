import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fixed_deposit_system",
                "root",
                "dc12345"
            );

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            System.out.println(e);

        }

        return con;
    }

    public static void main(String[] args) {

        getConnection();

    }

}