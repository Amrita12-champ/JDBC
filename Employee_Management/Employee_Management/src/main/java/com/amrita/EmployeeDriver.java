package com.amrita;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDriver {

    private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String USER = "root";
    private static final String PASSWORD = "a34862@TKRS";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to EmployeeDB Successfully!\n");

            Statement stmt = con.createStatement();

            // 1. CREATE (Insert)
//            String insertQuery = "INSERT INTO employee (name, salary, experience) VALUES (?, ?, ?)";
//            PreparedStatement insertStmt = con.prepareStatement(insertQuery);
//
//            insertStmt.setString(1, "Rahul Sharma");
//            insertStmt.setDouble(2, 55000.00);
//            insertStmt.setInt(3, 3);
//            insertStmt.executeUpdate();
//
//            insertStmt.setString(1, "Priya Patel");
//            insertStmt.setDouble(2, 75000.00);
//            insertStmt.setInt(3, 5);
//            insertStmt.executeUpdate();
//
//            System.out.println("Successfully Inserted 2 Employees.");

            // 2. READ (Select)
            String selectQuery = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("emp_id") +
                        " | Name: " + rs.getString("name") +
                        " | Salary: Rs." + rs.getDouble("salary") +
                        " | Experience: " + rs.getInt("experience") + "years");
            }


            // 3. UPDATE
//            String updateQuery = "UPDATE employee SET salary = ?, experience = ? WHERE emp_id = ?";
//            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
//            updateStmt.setDouble(1, 63000.00);
//            updateStmt.setInt(2, 10);
//            updateStmt.setInt(3, 1); // Updates the first inserted employee
//            int rowsUpdated = updateStmt.executeUpdate();
//            System.out.println(rowsUpdated + " Employee record updated successfully.");

            // 4. DELETE
//            String deleteQuery = "DELETE FROM employee WHERE emp_id = ?";
//            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
//            deleteStmt.setInt(1, 2); // Deletes the second inserted employee
//            int rowsDeleted = deleteStmt.executeUpdate();
//            System.out.println(rowsDeleted + " Employee record deleted successfully.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}