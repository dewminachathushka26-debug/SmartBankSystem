import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fixed_deposit_system",
                "root",
                "dc12345"
            );

            if(con != null){
                System.out.println("Database Connected Successfully!");
            }

        } catch (Exception e) {

            System.out.println("Connection Failed!");
            System.out.println(e);

        }

    }

}