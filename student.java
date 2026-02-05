import java.sql.*;
import java.util.Scanner;

public class student {

    static Scanner sc = new Scanner(System.in);
    static final String URL = "jdbc:mysql://localhost:3306/advjava";
    static final String USER = "root";
    static final String PASS = "Jaga@209";

    static void insertStudent() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO stu (roll, name, email) VALUES (?,?,?)")) {

            System.out.print("Enter Roll: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setString(3, email);

            ps.executeUpdate();
            System.out.println("Student inserted successfully");
        }
    }

    static void displayStudents() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM stu");
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Roll  Name  Email");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("roll") + "  " +
                                rs.getString("name") + "  " +
                                rs.getString("email")
                );
            }
        }
    }

    static void updateStudent() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE stu SET email=? WHERE roll=?")) {

            sc.nextLine();
            System.out.print("Enter New Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Roll: ");
            int roll = sc.nextInt();

            ps.setString(1, email);
            ps.setInt(2, roll);

            ps.executeUpdate();
            System.out.println("Student updated successfully");
        }
    }

    // DELETE
    static void deleteStudent() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM stu WHERE roll=?")) {

            System.out.print("Enter Roll to delete: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Student deleted successfully");
        }
    }
}

