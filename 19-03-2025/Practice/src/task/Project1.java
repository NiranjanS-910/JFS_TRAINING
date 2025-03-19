package task;

import java.sql.*;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventreg", "root", "Nethravarsha@1713");
            System.out.println("Connection established successfully...");

            boolean exit = false;

            while (!exit) {
                System.out.println("\nWELCOME TO EVENT REGISTRATION PORTAL");
                System.out.println("1. Register for Events");
                System.out.println("2. Edit Details");
                System.out.println("3. Delete Details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        registerUser(con, scanner);
                        break;
                    case 2:
                        editUser(con, scanner);
                        break;
                    case 3:
                        deleteUser(con, scanner);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting the application. Kudos!");
                        break;
                    default:
                        System.out.println("Invalid option! Please choose a number between 1 and 4.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registerUser(Connection con, Scanner scanner) {
        try {
            System.out.print("Enter Event Name: ");
            String eventname = scanner.nextLine();

            System.out.print("Enter College Name: ");
            String collegeName = scanner.nextLine();

            System.out.print("Enter 1st Participant's Name: ");
            String part1 = scanner.nextLine();

            System.out.print("Enter 1st Participant's Email: ");
            String gmail1 = scanner.nextLine();

            System.out.print("Enter 2nd Participant's Name: ");
            String part2 = scanner.nextLine();

            System.out.print("Enter 2nd Participant's Email: ");
            String gmail2 = scanner.nextLine();

            System.out.print("Enter Team Name: ");
            String team = scanner.nextLine();

            String query = "INSERT INTO eventmag (evename, clgname, part_1, gmail_1, part_2, gmail_2, team) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, eventname);
            ps.setString(2, collegeName);
            ps.setString(3, part1);
            ps.setString(4, gmail1);
            ps.setString(5, part2);
            ps.setString(6, gmail2);
            ps.setString(7, team);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Registration for the event was successful! All the best!");
            } else {
                System.out.println("Event registration unsuccessful. Please try again later!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editUser(Connection con, Scanner scanner) {
        try {
            System.out.print("Enter the Registration Number to edit details: ");
            int regNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new 1st Participant's Name: ");
            String newPart1 = scanner.nextLine();

            System.out.print("Enter new 1st Participant's Email: ");
            String newGmail1 = scanner.nextLine();

            System.out.print("Enter new 2nd Participant's Name: ");
            String newPart2 = scanner.nextLine();

            System.out.print("Enter new 2nd Participant's Email: ");
            String newGmail2 = scanner.nextLine();

            String query = "UPDATE eventmag SET part_1 = ?, gmail_1 = ?, part_2 = ?, gmail_2 = ? WHERE regno = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newPart1);
            ps.setString(2, newGmail1);
            ps.setString(3, newPart2);
            ps.setString(4, newGmail2);
            ps.setInt(5, regNumber);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Details updated successfully!");
            } else {
                System.out.println("Update failed! Registration number not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(Connection con, Scanner scanner) {
        try {
            System.out.print("Enter the Registration Number to delete: ");
            int regNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String query = "DELETE FROM eventmag WHERE regno = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, regNumber);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Details deleted successfully!");
            } else {
                System.out.println("Deletion failed! Registration number not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

