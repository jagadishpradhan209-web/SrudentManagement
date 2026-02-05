import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/advjava",
                "root",
                "Jaga@209"
        );
    }

    public static void main(String[] args) {
        try {
            student so = new student();
            Scanner sc = new Scanner(System.in);

            System.out.println("1.Insert  2.Display  3.Update  4.Delete");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) so.insertStudent();
            else if (choice == 2) so.displayStudents();
            else if (choice == 3) so.updateStudent();
            else if (choice == 4) so.deleteStudent();
            else System.out.println("Invalid choice");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
